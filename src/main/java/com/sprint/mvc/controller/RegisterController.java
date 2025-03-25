package com.sprint.mvc.controller;

import com.sprint.mvc.Dto.SignUpRep;
import com.sprint.mvc.Dto.SignUpReq;
import com.sprint.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class RegisterController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<SignUpRep> register(@RequestBody SignUpReq signUpReq) {

        SignUpRep signUpResponse = userService.signUp(signUpReq);
        return ResponseEntity.ok(signUpResponse);
    }

}
