package com.example.board.service;

import java.util.List;

import com.example.board.domain.BoardDTO;

public interface BoardService {
	public List<BoardDTO> list() throws Exception;

	int regi(BoardDTO dto) throws Exception;
	
	BoardDTO view(int seq);
}
