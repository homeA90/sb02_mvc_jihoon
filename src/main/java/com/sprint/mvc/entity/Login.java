package com.sprint.mvc.entity;

import com.sprint.mvc.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
public class Login {

    private final UserRepository userRepository;

    private String userId;
    private String password;

    public Login(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login() {
        String userId = this.userId;
        String password = this.password;

        User matchingUser = userRepository.findByUserId(userId);

        boolean loginResult = false;
        if (matchingUser !=null && userId.equals(matchingUser.getUserId()) && password.equals(matchingUser.getPassword())) {
            loginResult = true;
        }
        return loginResult;
    }
}
