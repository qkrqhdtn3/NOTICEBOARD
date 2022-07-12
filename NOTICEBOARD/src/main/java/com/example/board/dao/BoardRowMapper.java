package com.example.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.board.domain.BoardDTO;

public class BoardRowMapper implements RowMapper<BoardDTO>{
	
	@Override
	public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSeq(rs.getInt("seq"));
		boardDTO.setSubject(rs.getString("subject"));
		boardDTO.setContent(rs.getString("content"));
		boardDTO.setName(rs.getString("name"));
		boardDTO.setReg_date(rs.getString("reg_date"));
		boardDTO.setReadCount(rs.getInt("readCount"));
		return boardDTO;
	}
}
