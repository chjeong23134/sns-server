package com.poogie.sns.user.api;

import com.poogie.sns.security.JwtDto;
import com.poogie.sns.user.dao.AuthService;
import com.poogie.sns.user.domain.UserEntity;
import com.poogie.sns.user.dto.AuthRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final AuthService authService;

    @PostMapping("/auth/sign-in")
    public ResponseEntity<JwtDto> signIn(@RequestBody AuthRequestDto.SignIn req) {
        return new ResponseEntity<>(authService.signIn(req), HttpStatus.OK);
    }

    @PostMapping("/auth/sign-up")
    public ResponseEntity<UserEntity> signUp(@RequestBody AuthRequestDto.SignUp req) {
        return new ResponseEntity<>(authService.signUp(req), HttpStatus.OK);
    }
}
