package com.poogie.sns.user.api;

import com.poogie.sns.security.JwtDto;
import com.poogie.sns.user.dao.AuthService;
import com.poogie.sns.user.dto.AuthRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<JwtDto> signIn(@RequestBody AuthRequestDto.SignIn req) {
        return new ResponseEntity<>(authService.signIn(req), HttpStatus.OK);
    }
}
