package com.poogie.sns.room.api;

import com.poogie.sns.room.dao.ParticipantService;
import com.poogie.sns.room.domain.ParticipantEntity;
import com.poogie.sns.room.dto.RoomRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/participants")
public class ParticipantController {
    private final ParticipantService participantService;

    @PostMapping
    public ResponseEntity<ParticipantEntity> invite(@RequestBody RoomRequestDto.Invite req) {
        return new ResponseEntity<>(participantService.add(req), HttpStatus.OK);
    }
}
