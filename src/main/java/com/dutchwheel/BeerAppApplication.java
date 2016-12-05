package com.dutchwheel;

import com.dutchwheel.dao.UsersDaoImpl;
import com.dutchwheel.services.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class BeerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] {BeerAppApplication.class, JpaConfig.class}, args);
		UserServiceImpl userService = new UserServiceImpl();
		System.out.println(userService.getUserByToken("122"));
	}
}
