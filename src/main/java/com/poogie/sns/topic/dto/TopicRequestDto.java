package com.poogie.sns.topic.dto;

import com.poogie.sns.topic.domain.TopicEntity;
import lombok.Getter;

public class TopicRequestDto {
    @Getter
    public static class Create {
        private Long createUserId;
        private String content;

        public TopicEntity toEntity() {
            return TopicEntity.builder()
                    .createUserId(this.createUserId)
                    .content(this.content)
                    .isDeleted("N")
                    .build();
        }
    }
}
