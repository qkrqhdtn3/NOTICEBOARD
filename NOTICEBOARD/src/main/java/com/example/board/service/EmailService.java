package com.example.board.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService{
    boolean verifyEmail(String token);
}
