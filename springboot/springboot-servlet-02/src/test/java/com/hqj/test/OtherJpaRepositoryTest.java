package com.hqj.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.management.relation.Role;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hqj.App;
import com.hqj.dao.JuserRepository;
import com.hqj.dao.OtherRepository;
import com.hqj.dao.OtherRepositoryQueryAnnotation;
import com.hqj.dao.OtherRepositorySpecification;
import com.hqj.dao.RolesManyRepository;
import com.hqj.pojo.JUser;
import com.hqj.pojo.Menus;
import com.hqj.pojo.Other;
import com.hqj.pojo.Roles;
import com.hqj.service.impl.CityServiceImpl;
import com.hqj.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class OtherJpaRepositoryTest {

	@Autowired
	private OtherRepository otherRepository;

	@Autowired
	private OtherRepositoryQueryAnnotation otherQuery;

	@Autowired
	private OtherRepositorySpecification repositoryspec;

	@Test
	public void findAllOther() {
		List<Other> others = otherRepository.findAll();
		System.out.println(others.toString());
	}

	@Test
	public void saveOther() {
		Other other = new Other();
		other.setState(1);
		other.setDise("2019-06-27测试");
		otherRepository.save(other);
	}

	@Test
	public void testQueryByStateUseHQL() {
		List<Other> others = otherQuery.queryByStateUseHQL(1);
		for (Other other : others) {
			System.out.println(other.toString());
		}
	}

	/**
	 * JpaSpecificationExecutor 单条件查询测试
	 */
	@Test
	public void testJpaSpecificationExecutor1() {
		/**
		 * Specification<Other>:用于封装查询条件
		 */
		Specification<Other> spec = new Specification<Other>() {
//			Predicate:封装了 单个的查询条件 
			/**
			 * Root<Users> root:查询对象的属性的封装。 CriteriaQuery<?>
			 * query：封装了我们要执行的查询中的各个部分的信息，select from order by CriteriaBuilder
			 * cb:查询条件的构造器。定义不同的查询条件
			 */
			@Override
			public Predicate toPredicate(Root<Other> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// where name = '张三三'
				/**
				 * 参数一：查询的条件属性 "state"是Other属性名，不是字段名 参数二：条件的值
				 */
				Predicate pre = cb.equal(root.get("state"), 1);
				return pre;
			}
		};
		List<Other> list = repositoryspec.findAll(spec);
		for (Other other : list) {
			System.out.println(other.toString());
		}
	}

	/**
	 * JpaSpecificationExecutor 多条件查询测试
	 */
	@Test
	public void testJpaSpecificationExecutor2() {
		Specification<Other> specification = new Specification<Other>() {

			@Override
			public Predicate toPredicate(Root<Other> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// where name = '张三三' and age = 20
				List<Predicate> list = new ArrayList<Predicate>();
				list.add(cb.equal(root.get("state"), 1));
				list.add(cb.equal(root.get("dise"), "方法"));
				Predicate[] pres = new Predicate[list.size()];
				return cb.and(list.toArray(pres));
				// 第二种写法
//				return cb.and(cb.equal(root.get("state"), 1),cb.equal(root.get("dise"), "方法"));
				// or 条件
//				return cb.or(cb.equal(root.get("state"), 1),cb.equal(root.get("dise"), "方法"));
//				//有or 有 and  相当于：where (state=1 and dise='方法')  or id=1
//				return cb.or(cb.and(cb.equal(root.get("state"), 1),cb.equal(root.get("dise"), "方法")),cb.equal(root.get("id"), 1));
			}
		};
		// 排序
//		Sort sort=new Sort( new Order(Direction.DESC,"id"));
//		List<Other> listSort=repositoryspec.findAll(sort);

		List<Other> list = repositoryspec.findAll(specification);
		for (Other other : list) {
			System.out.println(other.toString());
		}
	}

	@Autowired
	private JuserRepository juserRepository;

	/**
	 * 测试一对多的关联关系
	 */
	@Test
	public void testOneMany() {
		// 创建一个用户
		JUser user = new JUser();
		user.setName("李四");
		user.setPassword("1123");
		user.setAddr("广州市天河区");

		// 创建一个角色
		Roles roles = new Roles();
		roles.setRolesName("分配员");

		// 关联
		roles.getUsers().add(user);
		user.setRoles(roles);

		// 保存
		juserRepository.save(user);
	}

	/**
	 * 测试一对多查询关系
	 */
	@Test
	public void testFindRoles() {
		List<JUser> jUsers = juserRepository.findAll();
		for (JUser jUser : jUsers) {
			Roles roles = jUser.getRoles();
			if (roles != null) {
				System.out.println(roles.toString());
			} else {
				System.out.println("roles is null");
			}
		}
	}

	@Autowired
	private RolesManyRepository rolesManyRepository;

	/**
	 * 测试多对多的关系，插入数据
	 */
	@Test
	public void testManySave() {
		// 创建角色对象
		Roles roles = new Roles();
		roles.setRolesName("产品经理");

		// 创建菜单对象
		Menus menus = new Menus();
		menus.setMenuName("工具管理系统");
		menus.setFatherId(0);// 父级菜单，id为0

		Menus menus2 = new Menus();
		menus2.setMenuName("项目管理");
		menus2.setFatherId(1);

		// 关联
		roles.gettMenus().add(menus);
		roles.gettMenus().add(menus2);
		menus.getRoles().add(roles);
		menus2.getRoles().add(roles);

		rolesManyRepository.save(roles);
	}

	/**
	 * 多对多关系，查询
	 */
	@Test
	public void testFindMany() {
		Roles r = this.rolesManyRepository.findOne(7);
		System.out.println("多对多：角色----"+r.toString());
		Set<Menus> menus = r.gettMenus();
		for (Menus m : menus) {
			System.out.println("多对多：角色对应菜单----"+m.toString());
		}
	}
	
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	/**
	 * 测试ehcache缓存
	 */
	@Test
	public void testChcache() {
		//ehcache缓存策略，第二次查询从缓存中拿
		System.out.println(userServiceImpl.findUsersById(1).toString());//查询值
		System.out.println(userServiceImpl.findUsersById(1).toString());//缓存值
		System.out.println(userServiceImpl.findUsersById(3).toString());//查询值
		System.out.println(userServiceImpl.findUsersById(3).toString());//缓存值
		System.out.println(userServiceImpl.findUsersById(4).toString());//查询值
		System.out.println(userServiceImpl.findUsersById(3).toString());//缓存值
	}
}
