package com.example.board.service;

import com.example.board.dao.EmailTokenRepository;
import com.example.board.domain.EmailToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.mail.internet.InternetAddress;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailTokenServiceImpl {
    private final EmailSenderServiceImpl emailSenderService;
    private final EmailTokenRepository emailTokenRepository;

    public String createEmailToken(String memberName, String receiverEmail) {
        Assert.notNull(memberName, "memberName은 필수입니다");
        Assert.hasText(receiverEmail, "receiverEmail은 필수입니다.");

//        이메일 토큰 저장
        EmailToken emailToken = EmailToken.createEmailToken(memberName);

        // 에러 체크
        emailToken.setExpirationDate(LocalDateTime.now().plusMinutes(5L));
        emailToken.setExpired(false);
        emailToken.setMemberId(memberName);

        emailTokenRepository.save(emailToken);

//        이메일 전송
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(receiverEmail);
        mailMessage.setSubject("회원가입 이메일 인증");
        mailMessage.setText("http://localhost:8081/confirm-email?token=" + emailToken.getEmailTokenId());
        mailMessage.setFrom("qkrqhdtn3@naver.com");
//        try {
//            mailMessage.setFrom(new InternetAddress("qkrqhdtn3"));
//        } catch (Exception e){
//            log.warn("EmailTokenServiceImpl.createEmailToken()" + e);
//        }
        emailSenderService.sendEmail(mailMessage);

        return emailToken.getEmailTokenId(); // 인증 전송 시 토큰 반환
    }

    public EmailToken findByIdAndExpirationDateAfterAndExpired(String emailTokenId) {
        Optional<EmailToken> emailToken = emailTokenRepository.findByEmailTokenIdAndExpirationDateAfterAndExpired(emailTokenId, LocalDateTime.now(), false);

        return emailToken.orElseThrow();
    }
}
