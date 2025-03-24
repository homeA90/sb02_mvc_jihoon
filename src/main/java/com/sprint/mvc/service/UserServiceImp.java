package com.sprint.mvc.service;

import com.sprint.mvc.Dto.SignUpReq;
import com.sprint.mvc.entity.User;
import com.sprint.mvc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.sprint.mvc.service.VaildationRegex.*;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public User signUp(SignUpReq signUpReq) {
        User user = new User(signUpReq.userId(), signUpReq.password(), signUpReq.email(), signUpReq.nickname());
        User matchingUser = userRepository.findByUserId(user.getUserId());

        if (!isValidUserId(user.getUserId())) {
            throw new IllegalArgumentException("The input must be between 6 and 30 characters.");
        }
        if (matchingUser != null && matchingUser.getUserId().equals(user.getUserId())) {
            throw new IllegalArgumentException("User Id already exists");
        }
        if (!isVaildPassword(user.getPassword())) {
            throw new IllegalArgumentException("Password must be between 12 and 50 characters long and include at least 2 letters, 2 numbers, and 2 special characters (!@#$%^&*).");
        }
        if (!isValidEmail(user.getEmail())) {
            throw new IllegalArgumentException("The email format is invalid.");
        }
        if (!isValidNickname(user.getNickname())) {
            throw new IllegalArgumentException("The nickname format is invalid.");
        }
        userRepository.save(user);
        System.out.println("pass");
        return user;
    }
}
