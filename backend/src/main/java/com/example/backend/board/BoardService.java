package com.example.backend.board;

import com.example.backend.board.model.Board;
import com.example.backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public void create(BoardDto.BoardRegister dto) {
        boardRepository.save(dto.toEntity());
    }

    public List<BoardDto.BoardListResponse> list() {
        List<Board> result = boardRepository.findAll();

        return result.stream().map(BoardDto.BoardListResponse::from).toList();
    }

    public BoardDto.BoardReadResponse read(Long boardIdx) {
        Board board = boardRepository.findById(boardIdx).orElseThrow();
        return BoardDto.BoardReadResponse.from(board);
    }
}
