package com.example.board.service;

import java.util.List;

import com.example.board.domain.BoardDTO;

public interface BoardService {
	public List<BoardDTO> list() throws Exception;

	public int regi(BoardDTO dto) throws Exception;
	
	public BoardDTO view(int seq);
	
	public int update(BoardDTO dto);
	
	public int delete(int seq);
}
