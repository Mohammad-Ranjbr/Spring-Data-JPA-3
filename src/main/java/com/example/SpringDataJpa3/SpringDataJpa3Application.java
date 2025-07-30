package com.example.SpringDataJpa3;

import com.example.SpringDataJpa3.auditor.AuditorAwareImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware") // This will enable the "Auditing" feature in the app.
public class SpringDataJpa3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpa3Application.class, args);
	}

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}

}
