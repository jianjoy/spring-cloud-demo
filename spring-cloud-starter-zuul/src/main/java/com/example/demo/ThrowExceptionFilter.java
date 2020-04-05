package com.example.demo;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ThrowExceptionFilter extends ZuulFilter {

	
	private static Logger log = LoggerFactory.getLogger(ThrowExceptionFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		
		
//		RequestContext ctx = RequestContext.getCurrentContext();
		
		log.info("This is a pre filter, it will throw a RuntimeException");
		doSomething();
//		try {
//		
//		}catch(Exception e) {
//			ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//			ctx.set("error.exception",e);
//		}
		
		return null;
	}

	private void doSomething() {
		throw new RuntimeException("Exist some errors...");
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
