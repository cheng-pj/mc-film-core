package com.mc.film;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.mc"})
@SpringBootApplication
public class McFilmCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(McFilmCoreApplication.class, args);
	}

}
