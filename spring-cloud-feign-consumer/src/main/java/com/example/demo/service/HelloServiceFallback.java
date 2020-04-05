package com.example.demo.service;

import org.springframework.stereotype.Component;

import com.example.demo.model.User;

@Component
public class HelloServiceFallback implements HellowService {

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return "error";
	}

	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return "error";
	}

	@Override
	public User hello(String name, Integer age) {
		// TODO Auto-generated method stub
		return new User("未知", 0);
	}

	@Override
	public String hello(User user) {
		// TODO Auto-generated method stub
		return "error";
	}

}
