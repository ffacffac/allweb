package com.hqj.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理方式五： 自定义全局异常处理
 * 
 * @author huangqj
 *
 */
@Configuration
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
//		ModelAndView mv = new ModelAndView();
//		// 不同的异常跳转不同的界面
//		if (ex instanceof ArithmeticException) {
//			mv.setViewName("error1");
//		} else if (ex instanceof NullPointerException) {
//			mv.setViewName("error2");
//		}
//		mv.addObject("error", ex);
//		return mv;
		return null;
	}
}
