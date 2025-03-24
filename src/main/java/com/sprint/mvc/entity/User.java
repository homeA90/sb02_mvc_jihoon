package com.sprint.mvc.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final UUID userUuid;
    private final String userId;
    private final String password;
    private final String email;
    private final String nickname;

    public User(String userId, String password, String email, String nickname) {
        this.userUuid = UUID.randomUUID();
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
    }




}
