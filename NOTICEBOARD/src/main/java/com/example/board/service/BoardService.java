package com.example.board.service;

import java.util.List;

import com.example.board.domain.Board;
import com.example.board.domain.BoardDTO;

public interface BoardService {
//	public List<BoardDTO> list() throws Exception;
	List<BoardDTO> list() throws Exception;

	public int regi(BoardDTO dto) throws Exception;
	
	public BoardDTO view(int boardId);
	
	public int update(BoardDTO dto);
	
	public int delete(int boardId);
}
