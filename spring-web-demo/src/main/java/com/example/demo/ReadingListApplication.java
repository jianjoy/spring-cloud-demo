package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReadingListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingListApplication.class, args);
		
//		new SpringApplicationBuilder(ReadingListApplication.class).web(WebApplicationType.SERVLET).run(args);
		
	}

}
