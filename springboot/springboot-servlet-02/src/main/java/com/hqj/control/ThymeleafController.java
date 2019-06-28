package com.hqj.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqj.pojo.Users;

@Controller
public class ThymeleafController {

	@RequestMapping("/showThy")
	public String showInfo(HttpServletRequest request, Model model) {
		model.addAttribute("msg", "thymeleaf第一个案例");
		model.addAttribute("date", new Date());
		List<Users> list = new ArrayList<>();
		Users users = new Users(1, "张三", 20);
		Users users1 = new Users(2, "李四", 22);
		Users users2 = new Users(3, "王五", 24);
		list.add(users);
		list.add(users1);
		list.add(users2);
		model.addAttribute("userList", list);
		// 域对象操作
		request.setAttribute("req", "MyHttpServletRequest");
		request.getSession().setAttribute("sess", "MySession");
		request.getSession().getServletContext().setAttribute("app", "MyApplication");
		return "index";
	}

	@RequestMapping("/show")
	public String showInfo1(HttpServletRequest request, Model model) {
		return "show";
	}
}
