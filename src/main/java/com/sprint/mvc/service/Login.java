package com.sprint.mvc.service;

import com.sprint.mvc.Dto.LoginRep;
import com.sprint.mvc.Dto.LoginReq;
import com.sprint.mvc.entity.User;
import com.sprint.mvc.repository.UserRepository;
import com.sprint.mvc.util.JwtUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
@RequiredArgsConstructor
public class Login {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public LoginRep login(LoginReq loginReq) {
        User user = userRepository.findByUserId(loginReq.id());
        if (user == null) {
            throw new RuntimeException("user not found");
        }

        // 비밀번호 검증
        if (!BCrypt.checkpw(loginReq.password(), user.getPassword())) {
            throw new RuntimeException("Password does not match.");
        }

        // JWT 토큰 생성 및 반환
        String token = jwtUtil.generateToken(user.getUserId());
        return LoginRep.loginRep(true,token);
    }


}
