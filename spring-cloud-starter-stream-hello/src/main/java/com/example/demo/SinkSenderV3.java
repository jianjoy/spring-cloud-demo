//package com.example.demo;
//
//import java.util.Random;
//import java.util.UUID;
//
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.Output;
//import org.springframework.context.annotation.Bean;
//import org.springframework.integration.annotation.InboundChannelAdapter;
//import org.springframework.integration.annotation.Poller;
//import org.springframework.integration.core.MessageSource;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.support.GenericMessage;
//
////@EnableBinding(value = SinkSenderV3.SinkOutput.class)
//public class SinkSenderV3 {
//
//	@Bean
//	@InboundChannelAdapter(value = SinkOutput.OUTPUT, poller = @Poller(fixedDelay = "1000"))
//	public MessageSource<String> timerMessageSource() {
//		MessageSource<String> ms = new MessageSource<String>() {
//			@Override
//			public Message<String> receive() {
//				String name = UUID.randomUUID().toString();
//				int age = new Random().nextInt(80) + 1;
//				String jsonStr = "{\"name\":\"" + name + "\",\"age\":" + age + "}";
//				return new GenericMessage<String>(jsonStr);
//			}
//		};
//		return ms;
//	}
//
//	public interface SinkOutput {
//		String OUTPUT = "output";
//		@Output(SinkOutput.OUTPUT)
//		MessageChannel output();
//	}
//
//}
