package com.example.SpringBootA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class SpringBootAApplication {

	@Value("${spring.application.name}")
	private static String applicationName;

	static Logger loggerApplication = LoggerFactory.getLogger(SpringBootAApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(SpringBootAApplication.class, args);
	}

}
