package com.example.backend.comment.model;

import com.example.backend.board.model.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CommentDto {
    @Getter
    public static class CommentRegister {
        @Schema(description = "댓글 내용", example = "comment_content")
        private String content;
        @Schema(description = "댓글 작성자", example = "comment_writer")
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
        @Schema(description = "댓글 번호")
        private Long idx;
        @Schema(description = "댓글 내용")
        private String content;
        @Schema(description = "댓글 작성자")
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
