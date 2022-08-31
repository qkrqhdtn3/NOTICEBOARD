package com.example.board.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emailtoken")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailToken {
    private static final long EMAIL_TOKEN_EXPIRATION_TIME_VALUE = 5L;
//    @GeneratedValue
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Id
    private String id;

    @Column(name = "expirationdate")
    private LocalDateTime expirationDate;

    private boolean expired;

    @Column(name = "memberid")
    private String memberId;

    // 이메일 토큰 생성
    public static EmailToken createEmailToken(String memberId) {
        EmailToken emailToken = new EmailToken();
//        5분 후 만료
        emailToken.expirationDate = LocalDateTime.now().plusMinutes(EMAIL_TOKEN_EXPIRATION_TIME_VALUE);
        emailToken.expired = false;
        emailToken.memberId = memberId;

        return emailToken;
    }


    public void setTokenToUsed() {
        this.expired = true;
    }
}
