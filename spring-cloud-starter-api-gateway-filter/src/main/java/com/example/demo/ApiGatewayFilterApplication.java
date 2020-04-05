package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;

@SpringCloudApplication
@EnableZuulProxy
@EnableConfigurationProperties(FilterConfigureation.class)
//@EnableDiscoveryClient
//@SpringBootApplication
public class ApiGatewayFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayFilterApplication.class, args);

	}

	@Bean
	public FilterLoader filterLoader(FilterConfigureation filterConfigureation) {
		FilterLoader filterLoader = FilterLoader.getInstance();
		filterLoader.setCompiler(new GroovyCompiler());
		FilterFileManager.setFilenameFilter(new GroovyFileFilter());
		try {
			FilterFileManager.init(filterConfigureation.getInterval(), filterConfigureation.getRoot() + "/pre",
					filterConfigureation.getRoot() + "/post");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return filterLoader;
	}

}
