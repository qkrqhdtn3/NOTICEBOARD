package com.example.board.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.board.domain.BoardDTO;
import com.example.board.domain.BoardSql;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardDAOImpl implements BoardDAO {

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final BoardRowMapper boardRowMapper;
	
	public BoardDAOImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		this.boardRowMapper = new BoardRowMapper();
	}
	
	@Override
	public List<BoardDTO> list() throws Exception {
		log.debug("query : {}", BoardSql.SELECT);
		
		return namedParameterJdbcTemplate.query(BoardSql.SELECT, EmptySqlParameterSource.INSTANCE, this.boardRowMapper);
	}
	
}
