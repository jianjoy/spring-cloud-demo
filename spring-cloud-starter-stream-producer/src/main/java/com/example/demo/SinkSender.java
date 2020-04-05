package com.example.demo;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

//@EnableBinding(value=Processor.class)
@EnableBinding(value = Source.class)
public class SinkSender {

	private static Logger log = LoggerFactory.getLogger(SinkSender.class);

//	@StreamListener(Processor.INPUT)
//	@SendTo(Processor.OUTPUT)
//	public Object receiveFromInput(Object payload) {
//		log.info("Received: "+payload);
//		return "From Input Channel Return = " + payload;
//	}

	@InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "200"))
	@Bean
	public MessageSource<String> timerMessageSource() {
		return new MessageSource<String>() {
			@Override
			public Message<String> receive() {
				String name = UUID.randomUUID().toString();
				int age = new Random().nextInt(80) + 1;
				return new GenericMessage<String>("{\"name\":\"" + name + "\",\"age\":" + age + "}");
			}
		};
	}

}
