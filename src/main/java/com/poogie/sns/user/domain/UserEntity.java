package com.poogie.sns.user.domain;

import com.poogie.sns.common.AutoDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Table(name="user")
public class UserEntity extends AutoDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String isDeleted;

    public void update(String password, String name) {
        if(!Objects.equals(this.password, password) && password != null) {
            this.password = password;
        }

        if(!Objects.equals(this.name, name) && name != null) {
            this.name = name;
        }
    }

    @Builder
    public UserEntity(Long id, String email, String password, String name, String isDeleted,
                      LocalDateTime createDate, LocalDateTime updateDate) {
        super(createDate, updateDate);

        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.isDeleted = isDeleted;
    }
}
