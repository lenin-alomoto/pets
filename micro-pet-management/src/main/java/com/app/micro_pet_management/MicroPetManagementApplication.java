package com.app.micro_pet_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MicroPetManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroPetManagementApplication.class, args);
	}

}
