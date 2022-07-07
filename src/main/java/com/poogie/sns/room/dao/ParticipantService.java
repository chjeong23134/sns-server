package com.poogie.sns.room.dao;

import com.poogie.sns.room.domain.ParticipantEntity;
import com.poogie.sns.room.dto.RoomRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantService {
    private final ParticipantRepository roomParticipantRepository;

    public ParticipantEntity add(RoomRequestDto.Invite req) {
        return roomParticipantRepository.save(req.toEntity());
    }

    public List<ParticipantEntity> findByUserId(Long userId) {
        return roomParticipantRepository.findByUserId(userId);
    }
}
