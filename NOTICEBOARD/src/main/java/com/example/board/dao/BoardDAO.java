package com.example.board.dao;

import java.util.List;

import com.example.board.domain.BoardDTO;

public interface BoardDAO {
	public List<BoardDTO> list() throws Exception;
}
