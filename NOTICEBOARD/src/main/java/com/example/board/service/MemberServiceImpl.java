package com.example.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.dao.MemberDAO;
import com.example.board.domain.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Override
	public MemberDTO login(MemberDTO dto) {
		log.warn("MemberServiceImpl.login()");
		return dao.login(dto).get(0);
	}

}
