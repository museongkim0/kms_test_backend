package com.example.backend.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BoardDto {
    @Getter
    public static class BoardRegister {
        private String title;
        private String content;
        private String writer;

        public Board toEntity() {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .build();
        }
    }

    @Getter @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BoardResponse {
        private Long idx;
        private String title;
        private String content;
        private String writer;

        public static BoardResponse from(Board board) {
            return BoardResponse.builder()
                    .idx(board.getIdx())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .build();
        }
    }
}
