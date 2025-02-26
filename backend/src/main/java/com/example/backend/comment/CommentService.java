package com.example.backend.comment;

import com.example.backend.board.model.Board;
import com.example.backend.comment.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public void create(CommentDto.CommentRegister dto, Board board) {
        commentRepository.save(dto.toEntity(board));
    }
}
