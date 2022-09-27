package com.example.board.service;

import com.example.board.domain.Member;
import com.example.board.domain.MemberDTO;

public interface MemberService {
    MemberDTO login(MemberDTO member);

    void join(MemberDTO member);

    long getMemberId(String memberName);
}
