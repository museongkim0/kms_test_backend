package com.example.backend.board;

import com.example.backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/create")
    public void create(@RequestBody BoardDto.BoardRegister dto) {
        boardService.create(dto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardDto.BoardListResponse>> list() {
        List<BoardDto.BoardListResponse> response = boardService.list();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/read/{boardIdx}")
    public ResponseEntity<BoardDto.BoardReadResponse> read(@PathVariable Long boardIdx) {
        BoardDto.BoardReadResponse response = boardService.read(boardIdx);

        return ResponseEntity.ok(response);
    }
}
