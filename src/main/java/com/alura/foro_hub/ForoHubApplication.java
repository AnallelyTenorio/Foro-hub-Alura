package com.alura.foro_hub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ForoHubApplication {

	public static void main(String[] args) {

		SpringApplication.run(ForoHubApplication.class, args);
	}

}
