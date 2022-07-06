package com.poogie.sns.room.api;

import com.poogie.sns.room.dao.RoomParticipantService;
import com.poogie.sns.room.dao.RoomService;
import com.poogie.sns.room.domain.RoomEntity;
import com.poogie.sns.room.domain.RoomParticipantEntity;
import com.poogie.sns.room.dto.RoomRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;
    private final RoomParticipantService roomParticipantService;

    @PostMapping("/create")
    public ResponseEntity<RoomEntity> create(@RequestBody RoomRequestDto.Create req) {
        return new ResponseEntity<>(roomService.add(req), HttpStatus.OK);
    }

    @PostMapping("/invite")
    public ResponseEntity<RoomParticipantEntity> invite(@RequestBody RoomRequestDto.Invite req) {
        return new ResponseEntity<>(roomParticipantService.add(req), HttpStatus.OK);
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<RoomEntity>> list(@PathVariable Long userId) {
        return new ResponseEntity<>(roomService.findByUserId(userId), HttpStatus.OK);
    }
}
