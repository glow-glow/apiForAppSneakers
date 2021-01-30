package com.example.apiForAppSneakers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApiForAppSneakersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiForAppSneakersApplication.class, args);
	}

}
