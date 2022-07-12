package com.example.board.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.board.domain.BoardDTO;
import com.example.board.service.BoardService;

@RequestMapping(value="/board/*")
@RestController
public class BoardController{

	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(Locale locale, ModelAndView mv) throws Exception {
		mv.setViewName("list");
		List<BoardDTO> list = service.list();
		mv.addObject("list", list);
//		ModelAndView model = new ModelAndView("list");
		
		return mv;
	}
}