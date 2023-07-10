package com.scient.labs.sciboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class })
@EnableWebMvc
public class SciboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SciboardApplication.class, args);
	}

}
