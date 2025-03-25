package com.sprint.mvc.service;

import com.sprint.mvc.Dto.SignUpRep;
import com.sprint.mvc.Dto.SignUpReq;
import com.sprint.mvc.entity.User;
import com.sprint.mvc.repository.UserRepository;
import com.sprint.mvc.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;


import static com.sprint.mvc.service.VaildationRegex.*;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public SignUpRep signUp(SignUpReq signUpReq) {

        String userId = signUpReq.userId();
        String password = signUpReq.password();
        String email = signUpReq.email();
        String nickname = signUpReq.nickname();

        User matchingUser = userRepository.findByUserId(userId);
        if (!isValidUserId(userId)) {
            throw new IllegalArgumentException("The input must be between 6 and 30 characters.");
        }
        if (matchingUser != null && matchingUser.getUserId().equals(userId)) {
            throw new IllegalArgumentException("User Id already exists");
        }

        if (!isVaildPassword(password)) {
            throw new IllegalArgumentException("Password must be between 12 and 50 characters long and include at least 2 letters, 2 numbers, and 2 special characters (!@#$%^&*).");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("The email format is invalid.");
        }
        if (!isValidNickname(nickname)) {
            throw new IllegalArgumentException("The nickname format is invalid.");
        }

        String hashedPassword = BCrypt.hashpw(signUpReq.password(), BCrypt.gensalt());
        User user = new User(userId, hashedPassword, email, nickname);

        userRepository.save(user);
        return SignUpRep.signUpReq(true, "회원 가입이 완료되었습니다.");
    }
}
