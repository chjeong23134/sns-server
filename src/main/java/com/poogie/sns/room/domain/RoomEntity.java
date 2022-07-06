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
@Table(name="room")
public class RoomEntity extends AutoDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long createUserId;
    private String name;

    @Builder
    public RoomEntity(Long id, Long createUserId, String name,
                      LocalDateTime createDate, LocalDateTime updateDate) {
        super(createDate, updateDate);

        this.id = id;
        this.createUserId = createUserId;
        this.name = name;
    }
}
