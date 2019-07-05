package com.hqj.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_j")
public class Users implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;

	@Column(name = "Name")
	private String username;

	@Column(name = "Address")
	private String address;

	private Integer userage;

	public Users(Integer userid, String username, Integer userage) {
		super();
		this.userid = userid;
		this.username = username;
		this.userage = userage;
	}

	public Users() {
		super();
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUserage() {
		return userage;
	}

	public void setUserage(Integer userage) {
		this.userage = userage;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	public String todostr11() {
//		return "Users [userid=" + userid + ", username=" + username + ", address=" + address + ", userage=" + userage
//				+ "]";
//	}
}
