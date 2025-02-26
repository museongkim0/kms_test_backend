package com.example.backend.comment;

import com.example.backend.board.BoardRepository;
import com.example.backend.board.BoardService;
import com.example.backend.board.model.Board;
import com.example.backend.comment.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public void create(CommentDto.CommentRegister dto, Long boardIdx) {
        Optional<Board> result = boardRepository.findById(boardIdx);
        if (result.isPresent()) {
           Board board = result.get();
           board.addCommentsCount();
           boardRepository.save(board);
           commentRepository.save(dto.toEntity(board));
        }
    }
}
