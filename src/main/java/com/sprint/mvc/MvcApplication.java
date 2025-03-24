package com.sprint.mvc;

import com.sprint.mvc.Dto.SignUpReq;
import com.sprint.mvc.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MvcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MvcApplication.class, args);

		UserService userService = context.getBean(UserService.class);

		SignUpReq signUpReq1 = new SignUpReq("homea90", "1q2w3e4r1234!@", "homea90@naver.com", "gg");
		userService.signUp(signUpReq1);

		SignUpReq signUpReq2 = new SignUpReq("homea90", "1q2w3e4r1234!@", "homea90@naver.com", "gg");
		userService.signUp(signUpReq2);

	}

}
