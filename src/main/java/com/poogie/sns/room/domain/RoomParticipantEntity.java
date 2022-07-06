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
@Table(name="room_participant")
public class RoomParticipantEntity extends AutoDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long roomId;
    private Long userId;
    // general
    // manager
    private String userClass;

    @Builder
    public RoomParticipantEntity(Long id, Long roomId, Long userId, String userClass,
                                 LocalDateTime createDate, LocalDateTime updateDate) {
        super(createDate, updateDate);

        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
        this.userClass = userClass;
    }
}
