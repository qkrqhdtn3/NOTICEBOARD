package com.example.board.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.time.format.FormatStyle;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController{
	
	@RequestMapping("/")
	public ModelAndView indexPage() {
		ModelAndView model = new ModelAndView("thymeleaf/index");
		LocalDateTime dt1 = LocalDateTime.now();
		String dtStr = dt1.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
		model.addObject("serverTime", dtStr);
		return model;
	}
}