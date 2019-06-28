package com.hqj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * SpringBoot整合Filter 方式一 <filter> <filter-name> FirstFilter </filter-name>
 * <filter-class>com.bjsxt.filter.FirstFilter</filter-class> </filter>
 * <filter-mapping> <filter-name>FirstFilter</filter-name>
 * <url-pattern>/first</url-pattern> </filter-mapping>
 */
//@WebFilter(filterName="FirstFilter",urlPatterns={"*.do","*.jsp"})
@WebFilter(filterName = "FirstFilter", urlPatterns = "/first")
public class FirstFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("进入FirstFilter");
		chain.doFilter(request, response);
		System.out.println("离开FirstFilter");

	}

	@Override
	public void destroy() {
	}

}
