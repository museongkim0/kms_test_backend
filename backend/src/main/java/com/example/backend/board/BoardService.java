package com.example.backend.board;

import com.example.backend.board.model.Board;
import com.example.backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public void create(BoardDto.BoardRegister dto) {
        boardRepository.save(dto.toEntity());
    }

    public BoardDto.BoardPageResponse list(int page, int size) {
        Page<Board> result = boardRepository.findAll(PageRequest.of(page,size));

        return BoardDto.BoardPageResponse.from(result);
    }

    public BoardDto.BoardReadResponse read(Long boardIdx) {
        Board board = boardRepository.findById(boardIdx).orElseThrow();
        return BoardDto.BoardReadResponse.from(board);
    }
}
