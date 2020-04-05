package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.example.demo.model.User;

//@EnableBinding(value=Processor.class)
@EnableBinding(value = Sink.class)
public class SinkReceiver {

	private static Logger log = LoggerFactory.getLogger(SinkReceiver.class);

//	@StreamListener(Processor.INPUT)
//	@SendTo(Processor.OUTPUT)
//	public Object receiveFromInput(Object payload) {
//		log.info("Received: "+payload);
//		return "From Input Channel Return = " + payload;
//	}

	@StreamListener(Sink.INPUT)
	public void receive(User user) {
		log.info("Receive: " + user);
	}

}
