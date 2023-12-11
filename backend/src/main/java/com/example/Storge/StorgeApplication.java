package com.example.Storge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StorgeApplication {
private static final Logger logger = LoggerFactory.getLogger(StorgeApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(StorgeApplication.class, args);
		logger.info("Application Start");
	}

}
