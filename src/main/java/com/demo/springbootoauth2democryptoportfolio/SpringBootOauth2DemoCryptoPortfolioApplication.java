package com.demo.springbootoauth2democryptoportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringBootOauth2DemoCryptoPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOauth2DemoCryptoPortfolioApplication.class, args);
	}

}
