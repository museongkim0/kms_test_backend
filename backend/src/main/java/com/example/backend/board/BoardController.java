package com.example.backend.board;

import com.example.backend.board.model.BoardDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @Operation(summary = "게시판 작성", description = "게시판을 작성하는 기능입니다.")
    @PostMapping("/create")
    public void create(@RequestBody BoardDto.BoardRegister dto) {
        boardService.create(dto);
    }

    @Operation(summary = "게시판 목록 조회", description = "게시판 목록을 페이지로 조회하는 기능입니다.")
    @GetMapping("/list")
    public ResponseEntity<BoardDto.BoardPageResponse> list(int page, int size) {
        BoardDto.BoardPageResponse response = boardService.list(page, size);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "게시판 상세 조회", description = "게시판을 상세 조회하는 기능입니다.")
    @GetMapping("/read/{boardIdx}")
    public ResponseEntity<BoardDto.BoardReadResponse> read(@PathVariable Long boardIdx) {
        BoardDto.BoardReadResponse response = boardService.read(boardIdx);

        return ResponseEntity.ok(response);
    }
}
