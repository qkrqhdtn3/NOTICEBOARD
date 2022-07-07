package com.example.board.controller;

import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value="/board/*")
@RestController
public class BoardController{

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(Locale locale) {
		ModelAndView model = new ModelAndView("list");
		return model;
	}
}