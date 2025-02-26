package com.example.backend.comment.model;

import com.example.backend.board.model.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CommentDto {
    @Getter
    public static class CommentRegister {
        private String content;
        private String writer;

        public Comment toEntity(Board board) {
            return Comment.builder()
                    .content(content)
                    .writer(writer)
                    .board(board)
                    .build();
        }
    }

    @Getter @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CommnetResponse {
        private Long idx;
        private String content;
        private String writer;

        public static CommnetResponse from(Comment comment) {
            return CommnetResponse.builder()
                    .idx(comment.getIdx())
                    .content(comment.getContent())
                    .writer(comment.getWriter())
                    .build();
        }
    }
}
