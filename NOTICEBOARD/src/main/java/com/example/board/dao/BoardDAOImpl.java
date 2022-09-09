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
    public Integer getMaxBoardId() {
        return namedParameterJdbcTemplate.queryForObject(BoardSql.MAX_BOARDID, (SqlParameterSource) null, Integer.class);
    }

    @Override
    public int regi(BoardDTO dto) {
//		log.warn("query : {}", BoardSql.INSERT);
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("boardId", dto.getBoardId())
                .addValue("memberId", dto.getMemberId()).addValue("subject", dto.getSubject())
                .addValue("content", dto.getContent()).addValue("regDate", dto.getReg_date())
                .addValue("readCount", dto.getReadCount());
        return namedParameterJdbcTemplate.update(BoardSql.INSERT, sqlParameterSource);
    }

    @Override
    public List<BoardDTO> view(int boardId) {
//		log.warn("dao.view()");
        String qry = BoardSql.SELECT + BoardSql.BOARDID_CONDITION;
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("boardId", boardId);
        return namedParameterJdbcTemplate.query(qry, sqlParameterSource, this.boardRowMapper);
    }

    @Override
    public void updateReadCount(int boardId) {
//		log.warn("dao.updateReadCount()");
        String qry = BoardSql.UPDATE_READ_COUNT + BoardSql.BOARDID_CONDITION;
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("boardId", boardId);
        namedParameterJdbcTemplate.update(qry, sqlParameterSource);
    }

    @Override
    public int update(BoardDTO dto) {
        log.warn("dao.update()");
        String qry = BoardSql.UPDATE + BoardSql.BOARDID_CONDITION;
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("boardId", dto.getBoardId())
                .addValue("subject", dto.getSubject()).addValue("content", dto.getContent());
        return namedParameterJdbcTemplate.update(qry, sqlParameterSource);
    }

    @Override
    public int delete(int boardId) {
        log.warn("dao.delete()");
        String qry = BoardSql.DELETE + BoardSql.BOARDID_CONDITION;
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("boardId", boardId);
        return namedParameterJdbcTemplate.update(qry, sqlParameterSource);
    }
}
