package io.larkin.phdplatformer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("development")
public class PhDPlatformerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhDPlatformerApplication.class, args);
	}
}
