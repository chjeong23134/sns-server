package com.poogie.sns.user.dao;

import com.poogie.sns.user.domain.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
