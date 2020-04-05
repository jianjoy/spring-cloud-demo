package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.HellowService;

@RestController
public class ConsumerController {

	@Autowired
	HellowService helloService;

	@RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
	public String helloConsumer() {
		return helloService.hello();
	}

	@RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
	public String helloConsumer2() {
		StringBuilder sb = new StringBuilder();
		sb.append(helloService.hello()).append("\n");
		sb.append(helloService.hello("DIDI")).append("\n");
		sb.append(helloService.hello("DIDI", 30)).append("\n");
		sb.append(helloService.hello(new User("DIDI", 30))).append("\n");
		return sb.toString();
	}

}
