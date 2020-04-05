package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@SpringBootTest(classes = HelloApplication.class)
@RunWith(SpringRunner.class)
public class HelloApplicationTest {

	
	
	@Test
	public void contextLoads() {
//		sender.timerMessageSource();
		try {
			Thread.sleep(1100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
