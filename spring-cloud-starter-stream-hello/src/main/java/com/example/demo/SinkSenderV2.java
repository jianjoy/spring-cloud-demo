//package com.example.demo;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.Output;
//import org.springframework.cloud.stream.messaging.Sink;
//import org.springframework.context.annotation.Bean;
//import org.springframework.integration.annotation.InboundChannelAdapter;
//import org.springframework.integration.annotation.Poller;
//import org.springframework.integration.annotation.Transformer;
//import org.springframework.integration.core.MessageSource;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.support.GenericMessage;
//
//@EnableBinding(value = SinkSenderV2.SinkOutput.class)
//public class SinkSenderV2 {
//
//	@Bean
//	@InboundChannelAdapter(value = SinkOutput.OUTPUT, poller = @Poller(fixedDelay = "300"))
//	public MessageSource<Date> timerMessageSource() {
//		MessageSource<Date> ms = new MessageSource<Date>() {
//			@Override
//			public Message<Date> receive() {
//				return new GenericMessage<Date>(new Date());
//			}
//		};
//		return ms;
//	}
//
//	@Transformer(inputChannel = SinkOutput.OUTPUT,outputChannel =Sink.INPUT)
//	public Object transform(Date message) {
//		String threadInfo = Thread.currentThread().toString();
//		String formatStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message);
//		System.out.println(threadInfo+"-transform end--------------------"+formatStr);
//		return formatStr;
//	}
//	
//	
//	public interface SinkOutput {
//		String OUTPUT = "output";
//
//		@Output(SinkOutput.OUTPUT)
//		MessageChannel output();
//	}
//
//}
