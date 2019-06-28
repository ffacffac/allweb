package com.hqj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.hqj.filter.SecondFilter;
import com.hqj.listener.SecondListener;
import com.hqj.servlet.SecondServlet;

/**
 * SpringBoot整合Servlet方式一
 *
 */
@SpringBootApplication
//第一种方式整合Servlet（FirstServlet）：在springBoot启动时会扫描@WebServlet，并将该类实例化
//第一种方式整合Filter（FirstFilter）
//第一种方式整合listener（FirstListener）
//@ServletComponentScan
@MapperScan("com.hqj.mapper")
@EnableCaching // 启动缓存
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

//	/**
//	 * 第二种整合servlet方式，注册Servlet
//	 */
//	@Bean
//	public ServletRegistrationBean getServletRegistrationBean() {
//		ServletRegistrationBean been = new ServletRegistrationBean(new SecondServlet());
//		been.addUrlMappings("/second");
//		return been;
//	}

//	/**
//	 * 整合filter，第二种方式
//	 * 
//	 * @return
//	 */
//	@Bean
//	public FilterRegistrationBean getFilterRegistrationBean() {
//		FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
////		bean.addUrlPatterns(new String[] { ".do", "*.jsp" });
//		bean.addUrlPatterns("/second");
//		return bean;
//	}

	/**
	 * 整合listener，方式二
	 */
	@Bean
	public ServletListenerRegistrationBean<SecondListener> getServletListenerRegistrationBean() {
		ServletListenerRegistrationBean<SecondListener> bean = new ServletListenerRegistrationBean<SecondListener>(
				new SecondListener());
		return bean;
	}
}
