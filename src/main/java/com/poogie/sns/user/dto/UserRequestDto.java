package com.poogie.sns.user.dto;

import lombok.Getter;

public class UserRequestDto {
    @Getter
    public static class SignUp {
        private String email;
        private String password;
        private String name;
    }

    @Getter
    public static class Update {
        private Long id;
        private String password;
        private String name;
    }
}
