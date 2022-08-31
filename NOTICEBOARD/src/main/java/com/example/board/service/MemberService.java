package com.example.board.service;

import com.example.board.domain.Member;
import com.example.board.domain.MemberDTO;

public interface MemberService {
    public MemberDTO login(MemberDTO dto);

    void join(Member member);
}
