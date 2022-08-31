package com.example.board.dao;

import com.example.board.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String>{
//    Optional<Member> findById(String id);
}
