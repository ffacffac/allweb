package com.hqj.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Roles和JUser是一对多关系
 * 
 */
@Entity
@Table(name = "roles")
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rolesid")
	private Integer rolesid;

	@Column(name = "rolesName")
	private String rolesName;

//	@Column(name="roles_name")
//	private String rolesname;

	// 存放的是JUser里面的roles
	@OneToMany(mappedBy = "roles")
	private Set<JUser> users = new HashSet<>();

	/**
	 * fetch = FetchType.EAGER:获取角色时，如果同时要去获取关联的菜单，则设置 FetchType.EAGER
	 * 将FetchType.LAZY(懒加载)关闭
	 * 1.在数据库中取值的时候，如果使用懒加载，就会只取出一层节点的数据，然后关闭session，这样再去取下一层级的数据的时候就会报出错误：session
	 * is closed 2.如果是EAGER，那么表示取出这条数据时，它关联的数据也同时取出放入内存中
	 * 
	 * @link{https://blog.csdn.net/sunqing0316/article/details/43852501}
	 */
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY) // 即添加角色又添加菜单
	// @JoinTable():映射中间表
	// joinColumns = @JoinColumn(name = "roles_id")：当前表（roles）中的主键所关联的中间表的外键字段
	// inverseJoinColumns = @JoinColumn(name = "menus_id")：另一个表关联的外键
	@JoinTable(name = "roles_menus", joinColumns = @JoinColumn(name = "roles_id"), inverseJoinColumns = @JoinColumn(name = "menus_id"))
	private Set<Menus> tMenus = new HashSet<>();

	public Roles() {
		super();
	}

	public Roles(Integer rolesid, String rolesName, Set<JUser> users) {
		super();
		this.rolesid = rolesid;
		this.rolesName = rolesName;
		this.users = users;
	}

	public Integer getRolesid() {
		return rolesid;
	}

	public void setRolesid(Integer rolesid) {
		this.rolesid = rolesid;
	}

	public String getRolesName() {
		return rolesName;
	}

	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}

//	public String getRolesname() {
//		return rolesname;
//	}
//
//	public void setRolesname(String rolesname) {
//		this.rolesname = rolesname;
//	}

	public Set<JUser> getUsers() {
		return users;
	}

	public void setUsers(Set<JUser> users) {
		this.users = users;
	}

	public Set<Menus> gettMenus() {
		return tMenus;
	}

	public void settMenus(Set<Menus> tMenus) {
		this.tMenus = tMenus;
	}

	@Override
	public String toString() {
		return "Roles [rolesid=" + rolesid + ", rolesName=" + rolesName + "]";
	}
}
