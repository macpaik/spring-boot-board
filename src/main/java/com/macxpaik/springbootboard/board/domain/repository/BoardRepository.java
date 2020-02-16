package com.macxpaik.springbootboard.board.domain.repository;

import com.macxpaik.springbootboard.board.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
