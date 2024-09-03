package com.ensah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ensah.core.dao")
@EntityScan(basePackages = "com.ensah.core.bo")
@ComponentScan(basePackages = "com.ensah.core")
public class ExamPlanAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamPlanAppApplication.class, args);
	}

}
