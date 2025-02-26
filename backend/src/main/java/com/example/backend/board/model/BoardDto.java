package com.example.backend.board.model;

import com.example.backend.comment.model.CommentDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BoardDto {
    @Getter
    public static class BoardRegister {
        @Schema(description = "게시판 제목", example = "board_title")
        private String title;
        @Schema(description = "게시판 내용", example = "board_content")
        private String content;
        @Schema(description = "게시판 작성자", example = "board_wirter")
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
    public static class BoardReadResponse {
        @Schema(description = "게시판 번호")
        private Long idx;
        @Schema(description = "게시판 제목")
        private String title;
        @Schema(description = "게시판 내용")
        private String content;
        @Schema(description = "게시판 작성자")
        private String writer;

        List<CommentDto.CommnetResponse> comments = new ArrayList<>();

        public static BoardReadResponse from(Board board) {
            return BoardReadResponse.builder()
                    .idx(board.getIdx())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .comments(board.getComments().stream().map(CommentDto.CommnetResponse::from).collect(Collectors.toList()))
                    .build();
        }
    }

    @Getter @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BoardResponse {
        @Schema(description = "게시판 번호")
        private Long idx;
        @Schema(description = "게시판 제목")
        private String title;
        @Schema(description = "게시판 내용")
        private String content;
        @Schema(description = "게시판 작성자")
        private String writer;
        @Schema(description = "게시판 댓글 수")
        private int commentsCount;

        public static BoardResponse from(Board board) {
            return BoardResponse.builder()
                    .idx(board.getIdx())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .commentsCount(board.getCommentsCount())
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BoardPageResponse {
        @Schema(description = "게시판 현재 페이지")
        private int page;
        @Schema(description = "게시판 페이지 사이즈")
        private int size;
        @Schema(description = "게시판 전체 수")
        private long totalElements;
        @Schema(description = "게시판 전체 페이지")
        private int totalPages;
        @Schema(description = "게시판 이전 페이지 여부")
        private boolean hasNext;
        @Schema(description = "게시판 다음 페이지 여부")
        private boolean hasPrevious;

        private List<BoardResponse> boardList;

        public static BoardPageResponse from(Page<Board> boardPage) {
            return BoardPageResponse.builder()
                    .page(boardPage.getNumber())
                    .size(boardPage.getSize())
                    .totalElements(boardPage.getTotalElements())
                    .totalPages(boardPage.getTotalPages())
                    .hasNext(boardPage.hasNext())
                    .hasPrevious(boardPage.hasPrevious())
                    .boardList(boardPage.stream().map(BoardResponse::from).collect(Collectors.toList()))
                    .build();
        }
    }
}
