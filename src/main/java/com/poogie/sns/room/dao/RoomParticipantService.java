package com.poogie.sns.room.dao;

import com.poogie.sns.room.domain.RoomParticipantEntity;
import com.poogie.sns.room.dto.RoomRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomParticipantService {
    private final RoomParticipantRepository roomParticipantRepository;

    public RoomParticipantEntity add(RoomRequestDto.Invite req) {
        return roomParticipantRepository.save(req.toEntity());
    }

    public List<RoomParticipantEntity> findByUserId(Long userId) {
        return roomParticipantRepository.findByUserId(userId);
    }
}
