package com.poogie.sns.room.api;

import com.poogie.sns.room.dao.RoomService;
import com.poogie.sns.room.domain.RoomEntity;
import com.poogie.sns.room.dto.RoomRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomEntity> create(@RequestBody RoomRequestDto.Create req) {
        return new ResponseEntity<>(roomService.add(req), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RoomEntity>> list(@RequestParam Long userId) {
        return new ResponseEntity<>(roomService.findByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomEntity> detail(@PathVariable Long id) {
        return new ResponseEntity<>(roomService.findById(id), HttpStatus.OK);
    }
}
