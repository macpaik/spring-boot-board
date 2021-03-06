package com.macxpaik.springbootboard.board.controller;

import com.macxpaik.springbootboard.board.dto.BoardDto;
import com.macxpaik.springbootboard.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/board")
    public String list(Model model) {
        List<BoardDto> boardList = boardService.getBoardList();

        model.addAttribute("boardList", boardList);
        return "board/list.html";
    }

    @GetMapping("/board/post")
    public String write() {
        return "board/write.html";
    }

    @PostMapping("/board/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/board";
    }

    @GetMapping("/board/post/{no}")
    public String detail(@PathVariable("no") Long no, Model model) {
        BoardDto boardDto = boardService.getPost(no);

        model.addAttribute("boardDto", boardDto);
        return "board/detail.html";
    }

    @GetMapping("/board/post/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model) {
        BoardDto boardDto = boardService.getPost(no);

        model.addAttribute("boardDto", boardDto);
        return "board/update.html";
    }

    @PutMapping("/board/post/edit/{no}")
    public String update(BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/board";
    }

    @DeleteMapping("/board/post/{no}")
    public String delete(@PathVariable("no") Long no, Model model) {
        boardService.deletePost(no);

        return "redirect:/board";
    }
}
