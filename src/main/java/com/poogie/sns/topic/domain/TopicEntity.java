package com.poogie.sns.topic.domain;

import com.poogie.sns.common.AutoDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Table(name="topic")
public class TopicEntity extends AutoDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long roomId;
    private Long createUserId;
    private String content;

    public void update(String content) {
        if(!Objects.equals(this.content, content) && content != null) {
            this.content = content;
        }
    }

    @Builder
    public TopicEntity(Long id, Long roomId, Long createUserId, String content,
                        LocalDateTime createDate, LocalDateTime updateDate) {
        super(createDate, updateDate);

        this.id = id;
        this.roomId = roomId;
        this.createUserId = createUserId;
        this.content = content;
    }
}
