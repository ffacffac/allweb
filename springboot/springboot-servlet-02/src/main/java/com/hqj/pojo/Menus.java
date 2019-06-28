package com.hqj.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 菜单与角色多对多关系 Menus-Roles
 * 
 */
@Entity
@Table(name = "menus")
public class Menus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menuId")
	private Integer menuId;

	@Column(name = "menuName")
	private String menuName;

	@Column(name = "menuUrl")
	private String menuUrl;

	@Column(name = "fatherId")
	private Integer fatherId;

	//mappedBy = "tMenus"对应的是Roles实体类中的tMenus
	@ManyToMany(mappedBy = "tMenus")
	private Set<Roles> roles = new HashSet<>();

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getFatherId() {
		return fatherId;
	}

	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Menus [menuId=" + menuId + ", menuName=" + menuName + ", menuUrl=" + menuUrl + ", fatherId=" + fatherId
				+ "]";
	}
}
