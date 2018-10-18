package com.vcom.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.vcom"})
public class ProjSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjSpringAppApplication.class, args);
	}
}
