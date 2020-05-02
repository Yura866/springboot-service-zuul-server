package com.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTimeTranscurFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PostTimeTranscurFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info("In the post filter");	


		Long initTime = (Long)request.getAttribute("initTime");
		Long finTime = System.currentTimeMillis();
		Long timeTransc = finTime-initTime;

		log.info("Time transcur  in seconds:  "+ timeTransc.doubleValue()/1000.00);
		log.info("Time transcur  in milisec: "+ timeTransc.doubleValue());


		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
