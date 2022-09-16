package com.example.board.service;

import java.util.List;

import com.example.board.domain.Board;
import com.example.board.domain.BoardDTO;

public interface BoardService {
//	public List<BoardDTO> list() throws Exception;
	List<BoardDTO> list() throws Exception;

	boolean regi(BoardDTO dto) throws Exception;
	
	BoardDTO view(int boardId);
	
	boolean update(BoardDTO dto);
	
	boolean delete(long boardId);
}
