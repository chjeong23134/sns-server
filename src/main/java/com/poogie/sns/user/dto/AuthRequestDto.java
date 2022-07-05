package com.poogie.sns.user.dto;

import lombok.Getter;

public class AuthRequestDto {
    @Getter
    public static class SignIn {
        private String email;
        private String password;
    }

    @Getter
    public static class SignUp {
        private String email;
        private String password;
        private String name;
    }
}
