package com.hqj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * SpringBoot整合Filter 方式一
 * 
 * @author huangqj
 *
 */
public class SecondFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("进入SecondFilter");
		chain.doFilter(request, response);
		System.out.println("离开SecondFilter");
	}

	@Override
	public void destroy() {
	}
}
