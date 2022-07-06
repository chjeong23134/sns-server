package com.poogie.sns.user.dao;

import com.poogie.sns.user.domain.UserEntity;
import com.poogie.sns.user.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity signUp(UserRequestDto.SignUp req) {
        UserEntity user = UserEntity.builder()
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .name(req.getName())
                .isDeleted("N")
                .build();

        return userRepository.save(user);
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity update(UserRequestDto.Update req) {
        UserEntity user = userRepository.findById(req.getId())
                .orElseThrow();

        user.update(passwordEncoder.encode(req.getPassword()), req.getName());

        return userRepository.save(user);
    }
}
