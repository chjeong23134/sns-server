package com.poogie.sns.topic.domain;

import com.poogie.sns.common.AutoDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Table(name="topic")
public class TopicEntity extends AutoDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long createUserId;
    private String content;
    private String isDeleted;

    @Builder
    public TopicEntity(Long id, Long createUserId, String content, String isDeleted,
                        LocalDateTime createDate, LocalDateTime updateDate) {
        super(createDate, updateDate);

        this.id = id;
        this.createUserId = createUserId;
        this.content = content;
        this.isDeleted = isDeleted;
    }
}
