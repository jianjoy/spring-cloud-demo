package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ZuulConfig {
	@RefreshScope
	@ConfigurationProperties("zuul")
	@Bean(name="zuul.CONFIGURATION_PROPERTIES")
	@Primary
	public ZuulProperties zuulProperties() {
		ZuulProperties p = new ZuulProperties();
//		System.out.println("-----------------------");
//		System.out.println(p.getRoutes());
		return p;
	}
}
