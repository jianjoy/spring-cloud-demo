package com.example.demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

@EnableBinding(value = Processor.class)
public class App2 {

	private static Logger logger = LoggerFactory.getLogger(App2.class);

	@InboundChannelAdapter(value = Processor.OUTPUT, poller = @Poller(fixedDelay = "2000"))
	@Bean
	public MessageSource<Date> timerMessageSource() {
		return new MessageSource<Date>() {
			@Override
			public Message<Date> receive() {
				return new GenericMessage<Date>(new Date());
			}
		};
	}

	@StreamListener(Processor.INPUT)
	public void receiveFromOutput(Object payload) {
		logger.info("Received: " + payload);
	}

}
