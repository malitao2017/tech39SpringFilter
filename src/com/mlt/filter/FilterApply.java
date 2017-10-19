package com.mlt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterApply implements Filter{

	@Override
	public void destroy() {
        System.out.println("过滤器：destroy...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("过滤器：before...");
        chain.doFilter(request, response);
        System.out.println("过滤器：after...");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
        System.out.println("过滤器：init...");
	}

}
