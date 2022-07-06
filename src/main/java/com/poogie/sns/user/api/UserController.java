package com.poogie.sns.user.api;

import com.poogie.sns.user.dao.UserService;
import com.poogie.sns.user.domain.UserEntity;
import com.poogie.sns.user.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserEntity> signUp(@RequestBody UserRequestDto.SignUp req) {
        return new ResponseEntity<>(userService.signUp(req), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> detail(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserEntity> update(@RequestBody UserRequestDto.Update req) {
        return new ResponseEntity<>(userService.update(req), HttpStatus.OK);
    }
}
