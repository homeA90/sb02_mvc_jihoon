package com.sprint.mvc;

import com.sprint.mvc.Dto.SignUpReq;
import com.sprint.mvc.entity.Login;
import com.sprint.mvc.service.RegisterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MvcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MvcApplication.class, args);
		RegisterService registerService = context.getBean(RegisterService.class);
		Login login = context.getBean(Login.class);

		SignUpReq signUpReq1 = new SignUpReq("homea90", "1q2w3e4r1234!@", "homea90@naver.com", "gg");
		registerService.signUp(signUpReq1);

		login.setUserId(signUpReq1.userId());
		login.setPassword(signUpReq1.password());
		boolean result = login.login();

		if (result) {
			System.out.println("login success");
		} else{
			System.out.println("login failed");
		}	}

}
