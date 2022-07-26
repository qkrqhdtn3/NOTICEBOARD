package com.example.board.dao;

import java.util.List;

import com.example.board.domain.MemberDTO;

public interface MemberDAO {
	public List<MemberDTO> login(MemberDTO dto);
}
