package com.poogie.sns.topic.dto;

import com.poogie.sns.topic.domain.TopicEntity;
import lombok.Getter;

public class TopicRequestDto {
    @Getter
    public static class Create {
        private Long roomId;
        private Long createUserId;
        private String content;

        public TopicEntity toEntity() {
            return TopicEntity.builder()
                    .roomId(this.roomId)
                    .createUserId(this.createUserId)
                    .content(this.content)
                    .build();
        }
    }

    @Getter
    public static class Update {
        private Long id;
        private String content;
    }
}
