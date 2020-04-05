package com.example.demo;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.rxjava.EnableRxJavaProcessor;
import org.springframework.cloud.stream.annotation.rxjava.RxJavaProcessor;
import org.springframework.context.annotation.Bean;

import rx.Observable;
import rx.functions.Func1;

//@EnableBinding(value=Processor.class)
@EnableRxJavaProcessor
public class App1 {

	private static Logger log = LoggerFactory.getLogger(App1.class);

//	@StreamListener(Processor.INPUT)
//	@SendTo(Processor.OUTPUT)
//	public Object receiveFromInput(Object payload) {
//		log.info("Received: "+payload);
//		return "From Input Channel Return = " + payload;
//	}

	@Bean
	public RxJavaProcessor<Date, String> processor() {
		return new RxJavaProcessor<Date, String>() {
			@Override
			public Observable<String> process(Observable<Date> input) {
				return input.map(new Func1<Date, String>() {
					@Override
					public String call(Date t) {
						log.info("Received: " + t.getTime());
						return String.valueOf(t.getTime());
					}
				}).buffer(5).map(new Func1<List<String>, String>() {
					@Override
					public String call(List<String> t) {
						StringBuilder sb = new StringBuilder();
						for (String str : t) {
							if (sb.length() > 0) {
								sb.append(",");
							}
							sb.append(str);
						}
						return "From Input Channel Return - " + sb.toString();
					}
				});
			}

		};
	}

}
