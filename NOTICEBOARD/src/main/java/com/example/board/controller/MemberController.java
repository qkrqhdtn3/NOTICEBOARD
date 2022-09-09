package com.example.board.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.board.domain.EmailToken;
import com.example.board.domain.Member;
import com.example.board.service.EmailTokenServiceImpl;
import com.example.board.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;

import com.example.board.domain.MemberDTO;
import com.example.board.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MemberController {
    //@Autowired
//    private MemberService service;
//@Autowired
//    private EmailTokenServiceImpl emailTokenService;
    private final MemberService service;
    private final EmailTokenServiceImpl emailTokenService;
    private final MemberServiceImpl memberService;

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
            session.setAttribute("memberId", dto2.getMemberId());
            session.setAttribute("memberName", dto2.getMemberName());
            return "Y";
        } else {
            return "N";
        }

    }

    @GetMapping(value = "member/join")
    public String join() {
        return "thymeleaf/member/join";
    }

    @GetMapping(value = "member/joinBeforeVerified")
    public String joinBeforeVerifiedView() {
        return "thymeleaf/member/joinBeforeVerified";
    }

    //    @RequestMapping(value = "member/joinBeforeVerified", method = RequestMethod.POST)
//    public String joinBeforeVerified(HttpServletRequest request) {
//        emailTokenService.createEmailToken(request.getParameter("memberId"), request.getParameter("email"));
//        return "thymeleaf/member/login";
//    }
    @RequestMapping(value = "member/joinBeforeVerified", method = RequestMethod.POST)
    public String joinBeforeVerified(HttpServletRequest request, Member member) {
//        log.warn("memberId: "+request.getParameter("memberId") + "\npassword: "+request.getParameter("password")+"\nnickname: "+request.getParameter("nickname")+"\nemail: "+request.getParameter("email"));

//        member.setMemberId(request.getParameter("memberId"));
//        member.setPassword(request.getParameter("password"));
        member.setNickname(request.getParameter("nickname"));

        log.warn("memberId: " + member.getMemberId() + "\npassword: " + member.getPassword() + "\nnickname: " + member.getNickname() + "\nemail: " + request.getParameter("email"));
        memberService.join(member);
        emailTokenService.createEmailToken(request.getParameter("memberId"), request.getParameter("email"));
        return "thymeleaf/member/login";
    }

//    @GetMapping(value = "member/mail")
//    public String mailView() {
//        return "thyemleaf/member/mail.html";
//    }

//    @RequestMapping(value = "member/mail", method = RequestMethod.POST)
//    public String mail(MailDTO mailDTO){
//        mailService.mailSend(mailDTO);
//    }


//    @ResponseBody
//    @RequestMapping(value="/emailAuth", method=RequestMethod.POST)
//    public String emailAuth(String email){
//        Random random = new Random();
//        int checkNum = random.nextInt(888888) + 111111;
//
//        String setFrom="qkrqhdtn3@naver.com";
//        String toMail=email;
//        String title="회원가입 인증 이메일 입니다.";
//        String content="홈페이지를 방문해주셔서 감사합니다."+
//                "<br><br>"+
//                "인증 번호는 "+checkNum+"입니다."+
//                "<br>"+
//                "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
//        try{
//            MimeMessage message = mailSender.createMimeMessage();
//            MimeMessageHelper helper=new MimeMessageHelper(message, true,"utf-8");
//            helper.setFrom(setFrom);
//            helper.setTo(toMail);
//            helper.setSubject(title);
//            helper.setText(content,true);
//            mailSender.send(message);
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//        return Integer.toString(checkNum);
//    }
}
