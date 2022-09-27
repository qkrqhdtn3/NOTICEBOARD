package com.example.board.service;

import com.example.board.dao.MemberRepository;
import com.example.board.domain.BoardDTO;
import com.example.board.domain.Member;
import org.modelmapper.ModelMapper;
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

	@Autowired
	private ModelMapper modelMapper;
	
//	@Override
//	public MemberDTO login(MemberDTO dto) {
//		log.warn("MemberServiceImpl.login()");
//		return dao.login(dto).get(0);
//	}
	@Override
	public MemberDTO login(MemberDTO memberDTO){
		log.warn("MemberServiceImpl.login()");
		Member member = memberRepository.findByMemberNameAndPassword(memberDTO.getMemberName(), memberDTO.getPassword());
		MemberDTO memberDTO2 = modelMapper.map(member, MemberDTO.class);
		return  memberDTO2;
	}

	@Override
	public void join(MemberDTO memberDTO) {
//		member.setMemberId();
		Member member = modelMapper.map(memberDTO, Member.class);
		memberRepository.save(member);
	}

	@Override
	public long getMemberId(String memberName) {
		return memberRepository.findByMemberName(memberName).getMemberId();
	}

}
