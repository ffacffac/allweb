package com.hqj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.hqj.servlet.SecondServlet;

/**
 * SpringBoot整合Servlet方式一
 *
 *
 */
@SpringBootApplication
//第一种方式（FirstServlet）：在springBoot启动时会扫描@WebServlet，并将该类实例化
//@ServletComponentScan
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	/**
	 * 第二种整合servlet方式
	 */
	@Bean
	public ServletRegistrationBean getServletRegistrationBean() {
		ServletRegistrationBean been = new ServletRegistrationBean(new SecondServlet());
		been.addUrlMappings("/second");
		return been;
	}
}
