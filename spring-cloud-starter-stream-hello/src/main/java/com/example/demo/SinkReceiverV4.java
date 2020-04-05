//package com.example.demo;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Sink;
//
//import com.example.demo.model.User;
//
////@EnableBinding(Sink.class)
//public class SinkReceiverV4 {
//
//	private static Logger logger = LoggerFactory.getLogger(SinkReceiverV4.class);
//
//	@StreamListener(SinkSenderV3.SinkOutput.OUTPUT)
//	public void receive(User user) {
//		logger.info("Received: " + user);
//	}
//
//}
