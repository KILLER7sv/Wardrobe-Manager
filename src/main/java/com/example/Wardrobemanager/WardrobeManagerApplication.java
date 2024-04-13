package com.example.Wardrobemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.example.Wardrobemanager.Repository")
public class WardrobeManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WardrobeManagerApplication.class, args);
	}

}
