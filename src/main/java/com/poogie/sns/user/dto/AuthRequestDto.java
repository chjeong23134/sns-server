package com.poogie.sns.user.dto;

import lombok.Getter;

public class AuthRequestDto {
    @Getter
    public static class SignIn {
        private String email;
        private String password;
    }
}
