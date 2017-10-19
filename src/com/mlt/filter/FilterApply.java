package com.mlt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//主要目的：过滤字符编码；其次，做一些应用逻辑判断等.
// Filter跟web应用一起启动
// 当web应用重新启动或销毁时，Filter也被销毁
public class FilterApply implements Filter{

	//私有配置文件
	private FilterConfig config = null;
	
	@Override
	public void destroy() {
        System.out.println("过滤器：destroy...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("过滤器：before...");
		//强制类型转化
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		// 获取web.xm设置的编码集，设置到Request、Response中
		req.setCharacterEncoding(config.getInitParameter("charset"));
		res.setContentType(config.getInitParameter("contentType"));
		res.setCharacterEncoding(config.getInitParameter("charset"));
		//将请求转发到目的地
		chain.doFilter(request, response);
        System.out.println("过滤器：after...");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.config = arg0;
        System.out.println("过滤器：init...");
	}

}
