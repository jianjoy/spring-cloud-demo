package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RefreshScope
public class ControllerMs {

	@Value("${zuul.routes.hello-service}")
	private String s;

	@Autowired
	private Environment env;

	@RequestMapping("/hello1")
	public String getHello() {
		return this.s;
	}

	@RequestMapping("/hello2")
	public String getHello2() {
		return env.getProperty("zuul.routes.hello-service", "未定义");
	}
}
