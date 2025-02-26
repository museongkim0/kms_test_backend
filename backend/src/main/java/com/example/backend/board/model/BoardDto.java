package com.example.backend.board.model;

import com.example.backend.comment.model.CommentDto;
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
    public static class BoardReadResponse {
        private Long idx;
        private String title;
        private String content;
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
        private Long idx;
        private String title;
        private String content;
        private String writer;
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
        private int page;
        private int size;
        private long totalElements;
        private int totalPages;
        private boolean hasNext;
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
