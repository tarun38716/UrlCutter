package com.assignment.ib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Tarun
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class UrlCutterApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlCutterApplication.class, args);
	}
}
