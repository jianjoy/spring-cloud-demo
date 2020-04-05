package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
public class ApiGateApplication {
	
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ApiGateApplication.class).web(true).run(args);
	}

}
