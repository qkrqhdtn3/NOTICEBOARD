package com.example.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl {
    private final JavaMailSender javaMailSender;

    public void sendEmail(SimpleMailMessage email){
        javaMailSender.send(email);
    }
}
