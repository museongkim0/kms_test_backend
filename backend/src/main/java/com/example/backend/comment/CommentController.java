package com.example.backend.comment;

import com.example.backend.board.model.Board;
import com.example.backend.comment.model.CommentDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @Operation(summary = "댓글 작성", description = "게시판에 댓글을 작성하는 기능입니다.")
    @PostMapping("/create/{boardIdx}")
    public void create(@RequestBody CommentDto.CommentRegister dto, @PathVariable Long boardIdx) {
        commentService.create(dto, boardIdx);
    }
}
