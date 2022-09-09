package com.example.board.dao;

import java.util.List;

import com.example.board.domain.BoardDTO;

public interface BoardDAO {
	public List<BoardDTO> list() throws Exception;

	Integer getMaxBoardId();

	int regi(BoardDTO dto);
	
	public List<BoardDTO> view(int boardId);
	
	public void updateReadCount(int boardId);
	
	public int update(BoardDTO dto);
	
	public int delete(int boardId);
}
