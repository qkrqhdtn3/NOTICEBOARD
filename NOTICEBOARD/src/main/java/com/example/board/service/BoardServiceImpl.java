package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.dao.BoardDAO;
import com.example.board.domain.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO dao;
	
	@Override
	public List<BoardDTO> list() throws Exception {
		return dao.list();
	}
	
	@Override
	public int regi(BoardDTO dto) throws Exception{
		if(dao.getMaxSeq()==null) {
			dto.setSeq(1);
		} else {
			dto.setSeq(dao.getMaxSeq() + 1);
		}
		
		return dao.regi(dto);
	}
}
