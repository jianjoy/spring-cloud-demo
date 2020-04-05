//package com.example.demo;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.messaging.Sink;
//import org.springframework.integration.annotation.ServiceActivator;
//import org.springframework.integration.annotation.Transformer;
//
//import com.example.demo.model.User;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@EnableBinding(Sink.class)
//public class SinkReceiverV3 {
//
//	private static Logger logger = LoggerFactory.getLogger(SinkReceiverV3.class);
//
//	@ServiceActivator(inputChannel = Sink.INPUT)
//	public void receive(User user) {
//		logger.info("Received: " + user);
//	}
//
//	@Transformer(inputChannel = SinkSenderV3.SinkOutput.OUTPUT, outputChannel = Sink.INPUT)
//	public User transform(String message) throws Exception {
//		System.out.println("transform : " + message);
//		ObjectMapper objectMapper = new ObjectMapper();
//		User user = objectMapper.readValue(message, User.class);
//		return user;
//	}
//
//}
