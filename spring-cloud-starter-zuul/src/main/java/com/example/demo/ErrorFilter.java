package com.example.demo;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ErrorFilter extends ZuulFilter{

	private static Logger logger = LoggerFactory.getLogger(ErrorFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		Throwable throwable = ctx.getThrowable();
		logger.error("this is a ErrorFilter: {}",throwable.getCause().getMessage());
		ctx.set("error.status_code",HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		ctx.set("error.exception",throwable.getCause());
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 10;
	}

}
