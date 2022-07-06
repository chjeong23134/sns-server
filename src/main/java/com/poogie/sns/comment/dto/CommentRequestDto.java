package com.poogie.sns.comment.dto;

import com.poogie.sns.comment.domain.CommentEntity;
import lombok.Getter;

public class CommentRequestDto {
    @Getter
    public static class Create {
        private Long topicId;
        private Long createUserId;
        private String content;

        public CommentEntity toEntity() {
            return CommentEntity.builder()
                    .topicId(this.topicId)
                    .createUserId(this.createUserId)
                    .content(this.content)
                    .isDeleted("N")
                    .build();
        }
    }
}
