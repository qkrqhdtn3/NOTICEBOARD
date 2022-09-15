package com.example.board.dao;

import com.example.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, String> {
    Optional<Board> findWithMaxBoardId;
}
