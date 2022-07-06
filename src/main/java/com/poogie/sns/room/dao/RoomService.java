package com.poogie.sns.room.dao;

import com.poogie.sns.room.domain.RoomEntity;
import com.poogie.sns.room.dto.RoomRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomEntity save(RoomRequestDto.Create req) {
        return roomRepository.save(req.toEntity());
    }
}
