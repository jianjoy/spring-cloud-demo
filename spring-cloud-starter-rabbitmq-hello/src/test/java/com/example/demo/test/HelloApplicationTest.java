package com.example.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.RabbitMQApplication;
import com.example.demo.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMQApplication.class)
public class HelloApplicationTest {
	
	
	@Autowired
	private Sender sender;
	
	@Test
	public void hello()throws Exception{
		sender.send();
	}

}
