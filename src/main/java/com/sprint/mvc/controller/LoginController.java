package com.sprint.mvc.controller;

import com.sprint.mvc.entity.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Login login;

    public LoginController(Login login) {
        this.login = login;
    }

    @PostMapping("/login")
    public String loginPost(
            @RequestParam String userId,
            @RequestParam String password,
            Model model
    ) {
        login.setUserId(userId);
        login.setPassword(password);
        boolean result = login.login();

        if (result) {
            System.out.println("login success");
        } else{
            System.out.println("login failed");
        }

        return "login";
    }
}
