package com.example.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.domain.MemberDTO;
import com.example.board.service.MemberService;

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
}
