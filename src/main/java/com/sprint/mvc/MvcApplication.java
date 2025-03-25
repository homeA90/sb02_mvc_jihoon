package com.sprint.mvc;

import com.sprint.mvc.Dto.SignUpReq;
import com.sprint.mvc.service.Login;
import com.sprint.mvc.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcApplication.class, args);

	}
}
