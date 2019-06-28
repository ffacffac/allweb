package com.hqj.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "other")
public class Other {
	/**
	 * GeneratedValue:JPA提供的四种标准用法为TABLE，SEQUENCE，IDENTITY，AUTO。
	 * a，TABLE：使用一个特定的数据库表格来保存主键。 
	 * b，SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
	 * c，IDENTITY：主键由数据库自动生成（主要是自动增长型） 
	 * d，AUTO：主键由程序控制。
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键由数据库生成
	@Column(name = "ID")
	private Integer id;
	@Column(name = "State")
	private Integer state;
	@Column(name = "Dise")
	private String dise;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getDise() {
		return dise;
	}

	public void setDise(String dise) {
		this.dise = dise;
	}

	@Override
	public String toString() {
		return "Other [id=" + id + ", state=" + state + ", dise=" + dise + "]";
	}

}
