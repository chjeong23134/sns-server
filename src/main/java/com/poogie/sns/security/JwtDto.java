package com.poogie.sns.security;

import com.poogie.sns.user.domain.UserEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JwtDto {
    private String accessJwt;
    private UserEntity user;
}
