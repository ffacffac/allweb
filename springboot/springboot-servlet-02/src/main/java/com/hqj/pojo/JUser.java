package com.hqj.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_j")
public class JUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Password")
	private String password;

	@Column(name = "Address")
	private String addr;

	@ManyToOne(cascade = CascadeType.PERSIST) // 即添加用户又添加角色
	// @JoinColumns()维护外键
	@JoinColumn(name = "roles_id")
	private Roles roles;

	public JUser(Integer id, String name, String password, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.addr = addr;
	}

	public JUser() {
		super();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "JUser [id=" + id + ", name=" + name + ", password=" + password + ", addr=" + addr + "]";
	}
}
