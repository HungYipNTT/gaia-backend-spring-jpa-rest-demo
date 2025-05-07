package com.sportfash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GaiaBackendDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GaiaBackendDemoApplication.class, args);
	}

}
