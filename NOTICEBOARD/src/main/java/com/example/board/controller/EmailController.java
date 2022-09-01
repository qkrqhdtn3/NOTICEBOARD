package com.example.board.controller;

import com.example.board.service.EmailServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
//import java.io.Serializable;

@Slf4j
@Validated
@RequiredArgsConstructor
@Controller
@RequestMapping
public class EmailController {
    private final EmailServiceImpl emailService;
//    http://localhost:8081/confirm-email?token=3addc9cb-d14b-4f26-838e-a85de79584ca
    @GetMapping("/confirm-email")
    public String viewConfirmEmail(@Valid @RequestParam String token){
//        try{
//            boolean result = emailService.verifyEmail(token);
//        } catch(Exception e){
//
//        }
        boolean result = emailService.verifyEmail(token);
        return "thymeleaf/member/login";
    }
}
