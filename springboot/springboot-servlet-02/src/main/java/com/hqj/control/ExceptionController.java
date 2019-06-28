package com.hqj.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/exception")
public class ExceptionController {

	/**
	 * 第一种异常处理方式： 异常处理，会统一跳转到templates文件下的error.html页面 必须以error命名
	 * 
	 * @return
	 */
	@RequestMapping("/show")
	public String show() {
		String str = null;
		int length = str.length();
		return "";
	}

	/**
	 * 此方法报IndexOutOfBoundsException错误，会由delExceptionHandler()方法进行处理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/show1")
	public String show1() {
		String str = "length";
		String s = str.substring(0, 15);
		return "index";
	}

//	/***
//	 	**第二种异常处理方式：
//	 * java.lang.ArithmeticException。 * 该方法需要返回一个 ModelAndView： 目的是可以让我们封装异常信息以及视
//	 * 图的指定。* 参数 Exception e:会将产生异常对象注入到方法中
//	 * 
//	 * @ExceptionHandler 中的value是数组参数，可以处理多个指定的异常
//	 */
//	@ExceptionHandler(value = { ArithmeticException.class, IndexOutOfBoundsException.class })
//	public ModelAndView delExceptionHandler(Exception e) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("error", e.toString());
//		mv.setViewName("error1");//交由error1页面展示
//		return mv;
//	}
}
