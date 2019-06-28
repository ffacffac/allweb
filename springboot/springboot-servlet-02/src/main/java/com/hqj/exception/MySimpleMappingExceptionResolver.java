package com.hqj.exception;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * 第四种异常处理方式
 * 
 * @author huangqj
 *
 *         通过 SimpleMappingExceptionResolver 做全局异常处理 *
 *         用这种方法的不足之处就是没法返回exception信息，前面页面无法展示
 */
@Configuration
public class MySimpleMappingExceptionResolver {

	/**
	 * 该方法必须要有返回值，为SimpleMappingExceptionResolver
	 * 
	 * @return SimpleMappingExceptionResolver
	 */
//	@Bean
//	public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
//		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
//		Properties mappings = new Properties();
//		/**
//		 * 参数一： 异常的类型， 注意必须是异常类型的全名. 参数二： 视图名称
//		 */
//		mappings.put("java.lang.ArithmeticException", "error1");
//		mappings.put("java.lang.NullPointerException", "error2");
//		// 设置异常与视图映射信息
//		resolver.setExceptionMappings(mappings);
//		return resolver;
//	}
}
