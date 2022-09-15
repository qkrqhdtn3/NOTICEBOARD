package com.example.board.service;

import com.example.board.domain.Member;
import com.example.board.domain.MemberDTO;

public interface MemberService {
    public Member login(Member member);

    void join(Member member);

    long getMemberId(String memberName);
}
