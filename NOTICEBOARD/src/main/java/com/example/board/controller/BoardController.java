package com.example.board.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import java.util.Locale;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

import com.example.board.domain.BoardDTO;
import com.example.board.service.BoardService;

@RequestMapping(value="/board/*")
@Controller
public class BoardController{

	@Autowired
	private BoardService service;
	
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public ModelAndView list(Locale locale, ModelAndView mv) throws Exception {
//		mv.setViewName("list");
//		List<BoardDTO> list = service.list();
//		mv.addObject("list", list);
////		ModelAndView model = new ModelAndView("list");
//		
//		return mv;
//	}

//	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<BoardDTO> list = service.list();
		model.addAttribute("list", list);
		
		return "/board/list";
	}
	
	@RequestMapping(value = "/regiView", method = RequestMethod.GET)
	public String regiView() throws Exception{
		return "/board/regi";
	}
	
	@ResponseBody
	@RequestMapping(value = "/regi", method = RequestMethod.POST)
	public String regi(BoardDTO dto) throws Exception {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdHHmmss");
		
//		BoardDTO dto = new BoardDTO();
//		dto.setName(request.getParameter("name"));
//		dto.setContent(request.getParameter("content"));
//		dto.setSubject(request.getParameter("subject"));
		dto.setReg_date(format.format(date));
		
		if(service.regi(dto)==1) {
			return "Y";
		} else {
			return "N";
		}
	}
}