//package com.example.demo;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.messaging.Sink;
//import org.springframework.integration.annotation.ServiceActivator;
//
//@EnableBinding(value=Sink.class)
//public class SinkReceiverV2 {
//
//	private static Logger logger = LoggerFactory.getLogger(SinkReceiverV2.class);
//	
//	
//	@ServiceActivator(inputChannel=Sink.INPUT)
//	public void receive(Object payload) {
//		String threadInfo = Thread.currentThread().toString();
//		logger.info(threadInfo+"-Received : "+payload);
//		
//	}
//	
//
//
//}
