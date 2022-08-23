package com.example.board.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

import com.example.board.domain.BoardDTO;
import com.example.board.service.BoardService;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@RequestMapping(value = "/board/*")
@Controller
public class BoardController {

    @Autowired
    private BoardService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        List<BoardDTO> list = service.list();
        model.addAttribute("list", list);

        return "thymeleaf/board/list";
    }

    @RequestMapping(value = "/regiView", method = RequestMethod.GET)
    public String regiView() throws Exception {
        return "thymeleaf/board/regi";
    }

    @ResponseBody
    @RequestMapping(value = "/regi", method = RequestMethod.POST)
    public String regi(BoardDTO dto) throws Exception {
//        Date date = new Date(System.currentTimeMillis());
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
//
//        dto.setReg_date(format.format(date));
        if (service.regi(dto) == 1) {
            return "Y";
        } else {
            return "N";
        }
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public String view(Model model, HttpServletRequest request) throws Exception {
//		log.warn("controller.view()");
//		log.warn(request.getParameter("seq"));
//        BoardDTO dto = service.view(Integer.parseInt((String) request.getParameter("seq")));
        BoardDTO dto = service.view(Integer.parseInt((String) request.getParameter("seq")));
        model.addAttribute("view", dto);
        return "thymeleaf/board/view";
    }

    @RequestMapping(value = "/goUpdateView", method = RequestMethod.POST)
    public String updateView(Model model, HttpServletRequest request) throws Exception {
//		log.warn("controller.updateView()");
//		log.warn(request.getParameter("seq"));
//		BoardDTO dto = service.view(6);
        BoardDTO dto = service.view(Integer.parseInt((String) request.getParameter("seq")));
//		log.warn("controller.updateView()2");
        model.addAttribute("view", dto);
        return "thymeleaf/board/update";
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(BoardDTO dto) {
//		log.warn("contorller.update()");
        if (service.update(dto) == 1) {
            return "Y";
        } else {
            return "N";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request) {
//		log.warn("controller.delete()");
        if (service.delete(Integer.parseInt((String) request.getParameter("seq"))) == 1) {
            return "Y";
        } else {
            return "N";
        }
    }

    @GetMapping("ex1")
    public String ex1() {
        return "thymeleaf/fragments/layout";
    }

    @GetMapping("ex2")
    public String ex2() {
        return "thymeleaf/fragments/layout2";
    }
}