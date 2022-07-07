package com.poogie.sns.room.dto;

import com.poogie.sns.room.domain.ParticipantEntity;
import com.poogie.sns.room.domain.RoomEntity;
import lombok.Getter;

public class RoomRequestDto {
    @Getter
    public static class Create {
        private Long createUserId;
        private String name;

        public RoomEntity toEntity() {
            return RoomEntity.builder()
                    .createUserId(this.createUserId)
                    .name(this.name)
                    .build();
        }
    }

    @Getter
    public static class Invite {
        private Long roomId;
        private Long userId;

        public ParticipantEntity toEntity() {
            return ParticipantEntity.builder()
                    .roomId(this.roomId)
                    .userId(this.userId)
                    .userClass("GENERAL")
                    .build();
        }
    }
}
