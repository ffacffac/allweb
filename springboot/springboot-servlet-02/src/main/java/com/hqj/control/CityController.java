package com.hqj.control;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqj.pojo.City;
import com.hqj.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityService cityService;

//	/**
//	 * 如果controller层，有这样的两个映射：@RequestMapping("/{page}")和@RequestMapping("/show")，
//	 * 前台的请求地址是http:127.0.0.1:8080/show，这个时候是优先走确定的映射@RequestMapping("/show")，
//	 * 而不走不确定的映射，如果不能映射到比如说：请求地址是：http:127.0.0.1:8080/show1，因为匹配不到，
//	 * 就会走不确定的方法@RequestMapping("/{page}")
//	 * {@link 原文：https://blog.csdn.net/u012060033/article/details/88941963}
//	 * 
//	 * @param page
//	 * @return
//	 */
//	@RequestMapping("/{page}")
//	public String showPage(@PathVariable String page) {
//		System.out.println("page==" + page);
//		return page;
//	}

	/**
	 * 解决异常的方式: 可以在跳转页面的方法中注入一个 City 对象。 注意： 由于 springmvc 会将该对象放入到 Model 中传递。
	 * key的名称会使用 该对象的驼峰式的命名规则来作为 key。 参数的变量名需要与对象的名称相同，将首字母小写，即:city *
	 * 如果想为传递的对象更改名称， 可以使用@ModelAttribute("aa")这表示当 前传递的对象的 key 为 aa。 那么我们在页面中获取该对象的
	 * key 也需要修改为 aa
	 * 
	 * @param users
	 * @return
	 */
	@RequestMapping("/showAddCity")
//	public String showAddCity(@ModelAttribute("aa")City city) {
	public String showAddCity(City city) {
		return "addMyCity";
	}

	/**
	 * 添加城市信息 
	 * 注意：如果在[showAddCity]使用@ModelAttribute("aa")表示参数别名，
	 * 因为当前这个方法如果校验不过通时，也返回addMyCity页面， 也需要传递City参数过去，
	 * 所以这里也需要添加@ModelAttribute("aa")注解
	 * 
	 * @param city
	 * @Valid 开启对city的数据校验
	 * @param result 封装了校验的结果
	 * @return
	 */
	@RequestMapping("/addCity")
	public String addCity(@Valid City city, BindingResult result) {
		// 以这种方式：addCity(City city)接收参数的时候，前端页面的input标签的name与City的属性名一致
		// 接收参数
//	public String addCity(@RequestParam(name = "name") String cityName, @RequestParam(name = "te") String te,
//			@RequestParam(name = "num") Integer num) {
//		City city = new City(0, cityName, te, num);
		if (result.hasErrors()) {
			return "addMyCity";
		}
		System.out.println(city.toString());
		cityService.addCity(city);
		return "addCityOk";
	}

	@RequestMapping("/findCityAll")
	public String findCityAll(Model model) {
		List<City> citys = cityService.findCityAll();
		model.addAttribute("citys", citys);
		return "cityList";
	}

	/**
	 * 
	 * @param id    与cityList中
	 *              <td><a th:herf="@{city/findCity(id=${city.id})}">修改</a></td>
	 *              请求的参数名称保持一致
	 * @param model
	 * @return
	 */
	@RequestMapping("/findCity")
	public String findCity(Integer id, Model model) {
		City city = cityService.findCityById(id);
		model.addAttribute("city", city);
		return "updateMyCity";
	}

	@RequestMapping("/editCity")
	public String editCity(City city) {
		cityService.updateCityById(city);
		System.out.println("更新成功-----------" + city.toString());
		return "redirect:/city/findCityAll";
	}

	@RequestMapping("/deleteCity")
	public String deleteCityById(Integer id) {
		cityService.deleteCityById(id);
		// 重定向
		return "redirect:/city/findCityAll";
	}
}
