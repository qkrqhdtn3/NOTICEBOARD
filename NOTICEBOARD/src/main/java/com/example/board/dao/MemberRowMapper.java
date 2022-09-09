package com.example.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.board.domain.MemberDTO;

public class MemberRowMapper implements RowMapper<MemberDTO> {

	@Override
//	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberName(rs.getString("memberName"));
		memberDTO.setPassword(rs.getString("password"));
		memberDTO.setNickname(rs.getString("nickname"));
		return memberDTO;
	}
}
