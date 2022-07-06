package com.poogie.sns.room.api;

import com.poogie.sns.room.dao.RoomParticipantService;
import com.poogie.sns.room.domain.RoomParticipantEntity;
import com.poogie.sns.room.dto.RoomRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/participants")
public class ParticipantController {
    private final RoomParticipantService roomParticipantService;

    @PostMapping
    public ResponseEntity<RoomParticipantEntity> invite(@RequestBody RoomRequestDto.Invite req) {
        return new ResponseEntity<>(roomParticipantService.add(req), HttpStatus.OK);
    }
}
