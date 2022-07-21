package com.example.board.dao;

import java.util.List;

import com.example.board.domain.BoardDTO;

public interface BoardDAO {
	public List<BoardDTO> list() throws Exception;

	Integer getMaxSeq();

	int regi(BoardDTO dto);
	
	public List<BoardDTO> view(int seq);
	
	public void updateReadCount(int seq);
	
	public int update(BoardDTO dto);
	
	public int delete(int seq);
}
