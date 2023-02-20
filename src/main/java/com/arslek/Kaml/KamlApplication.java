package com.arslek.Kaml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KamlApplication {

	public static void main(String[] args) {
		SpringApplication.run(KamlApplication.class, args);
	}

}
