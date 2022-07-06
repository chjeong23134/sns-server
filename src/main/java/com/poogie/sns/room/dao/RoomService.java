package com.poogie.sns.room.dao;

import com.poogie.sns.room.domain.RoomEntity;
import com.poogie.sns.room.domain.RoomParticipantEntity;
import com.poogie.sns.room.dto.RoomRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomParticipantService roomParticipantService;

    public RoomEntity add(RoomRequestDto.Create req) {
        return roomRepository.save(req.toEntity());
    }

    public List<RoomEntity> findByUserId(Long userId) {
        List<RoomParticipantEntity> roomParticipantEntitys = roomParticipantService.findByUserId(userId);
        List<RoomEntity> roomEntitys = new ArrayList<>();

        for(RoomParticipantEntity roomParticipantEntity : roomParticipantEntitys) {
            roomEntitys.add(roomRepository.findById(roomParticipantEntity.getRoomId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "RoomEntity 조회 실패")));
        }

        return roomEntitys;
    }
}
