package com.example.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String memberName;
    private String nickname;
    private String email;
    private String picture;
    private Role role;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String memberName, String email, String picture){
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.memberName = memberName;
        this.email = email;
        this.picture = picture;
    }
    public static OAuthAttributes of(String registrationId, String memberNameAttributeName, Map<String, Object> attributes){
        return ofGoogle(memberNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String memberNameAttributeName, Map<String, Object> attributes){
        return OAuthAttributes.builder()
                .memberName((String) attributes.get("memberName"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(memberNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String memberNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        log.info("naver response : " + response);

        return OAuthAttributes.builder()
                .memberName((String) response.get("email"))
                .email((String) response.get("email"))
                .nickname((String) response.get("email"))
                .attributes(response)
                .nameAttributeKey(memberNameAttributeName)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .memberName(memberName)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }
}
