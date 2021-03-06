package com.poogie.sns.room.domain;


import com.poogie.sns.common.AutoDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Table(name="participant")
public class ParticipantEntity extends AutoDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long roomId;
    private Long userId;
    // general
    // manager
    private String userClass;

    @Builder
    public ParticipantEntity(Long id, Long roomId, Long userId, String userClass,
                                 LocalDateTime createDate, LocalDateTime updateDate) {
        super(createDate, updateDate);

        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
        this.userClass = userClass;
    }
}
