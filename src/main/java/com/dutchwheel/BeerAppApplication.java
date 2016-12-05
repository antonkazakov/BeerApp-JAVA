package com.dutchwheel;

import com.dutchwheel.dao.UsersDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeerAppApplication.class, args);
		UsersDaoImpl d = new UsersDaoImpl();

		System.out.println("+sdf+ " + d.getUserByToken("fdgdfcg").getApiKey());
	}
}
