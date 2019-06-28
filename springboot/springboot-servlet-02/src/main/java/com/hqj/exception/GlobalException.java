package com.hqj.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 第三种异常处理方式：处理全局异常
 * 
 * 这种异常处理不管在那个controller产生异常都可以处理
 * 比如产生ArithmeticException、IndexOutOfBoundsException等异常都可到达此处
 * 推荐使用
 */
@ControllerAdvice
public class GlobalException {
	/***
	 * java.lang.ArithmeticException。 * 该方法需要返回一个 ModelAndView： 目的是可以让我们封装异常信息以及视
	 * 图的指定。* 参数 Exception e:会将产生异常对象注入到方法中
	 * 
	 * @ExceptionHandler 中的value是数组参数，可以处理多个指定的异常
	 */
	@ExceptionHandler(value = { ArithmeticException.class, IndexOutOfBoundsException.class })
	public ModelAndView delExceptionHandler(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("error", e.toString());
		mv.setViewName("error1");// 交由error1页面展示
		return mv;
	}
}
