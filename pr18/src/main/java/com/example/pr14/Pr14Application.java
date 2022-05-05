package com.example.pr14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories // Чтобы репозиторий можно было привязать (На работу не повлияет, только уберет красное)
public class Pr14Application {

	public static void main(String[] args) {
		SpringApplication.run(Pr14Application.class, args);
	}

}
