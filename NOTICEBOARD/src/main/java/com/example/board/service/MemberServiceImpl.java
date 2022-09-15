package com.example.board.service;

import com.example.board.dao.MemberRepository;
import com.example.board.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.dao.MemberDAO;
import com.example.board.domain.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

//	@Autowired
//	private MemberDAO dao;
	@Autowired
	private MemberRepository memberRepository;
	
//	@Override
//	public MemberDTO login(MemberDTO dto) {
//		log.warn("MemberServiceImpl.login()");
//		return dao.login(dto).get(0);
//	}
	@Override
	public Member login(Member member){
		log.warn("MemberServiceImpl.login()");
		return memberRepository.findByMemberNameAndPassword(member.getMemberName(), member.getPassword());
	}

	@Override
	public void join(Member member) {
//		member.setMemberId();
		memberRepository.save(member);
	}

	@Override
	public long getMemberId(String memberName) {
		return memberRepository.findByMemberName(memberName).getMemberId();
	}

}
