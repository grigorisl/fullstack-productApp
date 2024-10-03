package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.company.repository")
public class FullStackAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullStackAppApplication.class, args);
	}

}
