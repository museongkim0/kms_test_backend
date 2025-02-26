package com.example.backend.comment;

import com.example.backend.board.model.Board;
import com.example.backend.comment.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/create/{boardIdx}")
    public void create(@RequestBody CommentDto.CommentRegister dto, @PathVariable Long boardIdx) {
        commentService.create(dto, boardIdx);
    }
}
