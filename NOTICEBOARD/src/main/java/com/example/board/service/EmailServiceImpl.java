package com.example.board.service;

import com.example.board.dao.MemberRepository;
import com.example.board.domain.EmailToken;
import com.example.board.domain.Member;
import com.example.board.domain.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class EmailServiceImpl implements EmailService{

    private final EmailTokenService emailTokenService;
    private final MemberRepository memberRepository;
    public boolean verifyEmail(String token){
        EmailToken findEmailToken = emailTokenService.findByIdAndExpirationDateAfterAndExpired(token);

//        이메일 인증 성공
//        Optional<MemberDTO> findMember = memberRepository.findById(findEmailToken.getMemberId());
        Optional<Member> findMember = memberRepository.findByMemberId(findEmailToken.getMemberId());
        findEmailToken.setTokenToUsed();

        if(findMember.isPresent()){
            Member member = findMember.get();
            member.setVerified();
            return true;
        } else{
            return false;
        }
    }
}
