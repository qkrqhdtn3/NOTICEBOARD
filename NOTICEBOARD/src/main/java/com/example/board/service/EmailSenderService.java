package com.example.board.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailSenderService {
    void sendEmail(SimpleMailMessage email);
}
