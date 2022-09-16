package com.example.board.dao;

import com.example.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, String> {
    @Query(value = "SELECT max(b.boardId) FROM Board b")
    Optional<Integer> MaxByBoardId();

    Optional<Board> findByBoardId(long boardId);

    Long deleteByBoardId(long boardId);
}
