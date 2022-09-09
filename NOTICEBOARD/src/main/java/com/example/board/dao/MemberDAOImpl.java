package com.example.board.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.board.domain.MemberDTO;
import com.example.board.domain.MemberSql;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private MemberRowMapper memberRowMapper;
	
	public MemberDAOImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
		this.memberRowMapper=new MemberRowMapper();
	}
	
	@Override
	public List<MemberDTO> login(MemberDTO dto) {
		log.warn("MemberDAOImpl.login()");
		String query = MemberSql.SELECT
				+ MemberSql.MEMBER_NAME_CONDITION
				+ MemberSql.PASSWORD_CONDITION;
		SqlParameterSource parameterSource = new MapSqlParameterSource("memberName", dto.getMemberName())
				.addValue("password", dto.getPassword());
		return namedParameterJdbcTemplate.query(query, parameterSource, memberRowMapper);
	}

}
