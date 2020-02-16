package com.macxpaik.springbootboard.board.service;

import com.macxpaik.springbootboard.board.domain.repository.BoardRepository;
import com.macxpaik.springbootboard.board.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}
