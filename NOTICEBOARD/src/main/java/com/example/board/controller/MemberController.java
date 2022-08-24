package com.example.board.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.domain.MemberDTO;
import com.example.board.service.MemberService;

import java.util.Random;

@Controller
public class MemberController {

    @Autowired
    private MemberService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login() {
        return "thymeleaf/member/login";
//        return "member/login";
    }

    @ResponseBody
    @RequestMapping(value = "/member/login", method = RequestMethod.POST)
    public String regi(MemberDTO dto, HttpSession session) {
        MemberDTO dto2 = service.login(dto);
        if (dto != null) {
            session.setAttribute("id", dto2.getId());
            return "Y";
        } else {
            return "N";
        }

    }

    @GetMapping(value = "member/join")
    public String join() {
        return "thymeleaf/member/join";
    }

    @ResponseBody
    @RequestMapping(value="/emailAuth", method=RequestMethod.POST)
    public String emailAuth(String email){
        Random random = new Random();
        int checkNum = random.nextInt(888888) + 111111;

        String setFrom="qkrqhdtn3@naver.com";
        String toMail=email;
        String title="회원가입 인증 이메일 입니다.";
        String content="홈페이지를 방문해주셔서 감사합니다."+
                "<br><br>"+
                "인증 번호는 "+checkNum+"입니다."+
                "<br>"+
                "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
        try{
//            MimeMessage message = mailSender.createMimeMessage();
//            MimeMessageHelper helper=new MimeMessageHelper(message, true,"utf-8");
//            helper.setFrom(setFrom);
//            helper.setTo(toMail);
//            helper.setSubject(title);
//            helper.setText(content,true);
//            mailSender.send(message);
        } catch(Exception e){
            e.printStackTrace();
        }
        return Integer.toString(checkNum);
    }
}
