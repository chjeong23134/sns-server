package com.poogie.sns.user.dto;

import lombok.Getter;

public class UserRequestDto {
    @Getter
    public static class SignUp {
        private String email;
        private String password;
        private String name;
    }
}
