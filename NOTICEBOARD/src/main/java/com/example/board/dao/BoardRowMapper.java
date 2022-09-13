package com.example.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.board.domain.BoardDTO;

public class BoardRowMapper implements RowMapper<BoardDTO>{
	
	@Override
	public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoardId(rs.getLong("boardId"));
		boardDTO.setMemberId(rs.getLong("memberId"));
		boardDTO.setSubject(rs.getString("subject"));
		boardDTO.setContent(rs.getString("content"));
		boardDTO.setRegDate(rs.getString("regDate"));
		boardDTO.setReadCount(rs.getInt("readCount"));
		return boardDTO;
	}
}
