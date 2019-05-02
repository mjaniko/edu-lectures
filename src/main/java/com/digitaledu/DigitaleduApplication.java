package com.digitaledu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DigitaleduApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitaleduApplication.class, args);
	}

}
