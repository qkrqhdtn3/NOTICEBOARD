package com.example.board.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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
//		log.debug("query : {}", BoardSql.SELECT);
		
		return namedParameterJdbcTemplate.query(BoardSql.SELECT, EmptySqlParameterSource.INSTANCE, this.boardRowMapper);
	}
	
	@Override
	public Integer getMaxSeq() {
		return namedParameterJdbcTemplate.queryForObject(BoardSql.MAX_SEQ, (SqlParameterSource)null, Integer.class);
	}
	
	@Override
	public int regi(BoardDTO dto) {
		log.warn("query : {}", BoardSql.INSERT);
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("seq", dto.getSeq())
				.addValue("subject", dto.getSubject())
				.addValue("content", dto.getContent())
				.addValue("name", dto.getName())
				.addValue("reg_date", dto.getReg_date())
				.addValue("readCount", dto.getReadCount());
		return namedParameterJdbcTemplate.update(BoardSql.INSERT, sqlParameterSource);
	}

	@Override
	public BoardDTO view(int seq) {
		String qry = BoardSql.SELECT + BoardSql.SEQ_CONDITION;
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("seq", seq);
		return namedParameterJdbcTemplate.queryForObject(qry, sqlParameterSource, BoardDTO.class);
	}

	@Override
	public void updateReadCount(int seq) {
		String qry = BoardSql.UPDATE_READCOUNT + BoardSql.SEQ_CONDITION;
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("seq", seq);
		namedParameterJdbcTemplate.update(qry, sqlParameterSource);
	}
}
