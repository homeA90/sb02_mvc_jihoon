package com.sprint.mvc.controller;

import com.sprint.mvc.Dto.LoginRep;
import com.sprint.mvc.Dto.LoginReq;
import com.sprint.mvc.service.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class LoginController {

    private final Login login;


    @PostMapping("/login")
    public ResponseEntity<LoginRep> login(@RequestBody LoginReq loginReq) {

        LoginRep loginResponse = login.login(loginReq);
        return ResponseEntity.ok(loginResponse);
    }
}
