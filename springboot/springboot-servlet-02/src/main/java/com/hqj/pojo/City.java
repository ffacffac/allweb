package com.hqj.pojo;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 数据校验
 * 
 * @author huangqj
 *
 */
public class City {
	private Integer id;
	@NotBlank(message = "城市名称不能为空") // 非空校验，校验注解可以叠加
	private String name;
	@NotBlank
	@Length(max = 20, message = "字符长度不能超过20")
	private String te;
	@Max(value = 100L, message = "数值大小不能超过100")
	private Integer num;

	public City() {
		super();
	}

	public City(Integer id, String name, String te, Integer num) {
		super();
		this.id = id;
		this.name = name;
		this.te = te;
		this.num = num;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTe() {
		return te;
	}

	public void setTe(String te) {
		this.te = te;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", te=" + te + ", num=" + num + "]";
	}
}
