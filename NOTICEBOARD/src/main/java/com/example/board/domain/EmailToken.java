package com.example.board.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailToken {
    private static final long EMAIL_TOKEN_EXPIRATION_TIME_VALUE = 5L;

    @Id
    private String id;

    private LocalDateTime expirationDate;

    private boolean expired;

    private Long memberId;

    public static EmailToken createEmailToken(Long memberId){
        EmailToken emailToken = new EmailToken();
//        5분 후 만료
        emailToken.expirationDate = LocalDateTime.now().plusMinutes(EMAIL_TOKEN_EXPIRATION_TIME_VALUE);
        emailToken.expired = false;
        emailToken.memberId = memberId;

        return emailToken;
    }


    public void setTokenToUsed(){
        this.expired = true;
    }
}
