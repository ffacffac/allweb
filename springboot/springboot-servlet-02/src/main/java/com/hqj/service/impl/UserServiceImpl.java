package com.hqj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hqj.dao.UserDaoImpl;
import com.hqj.dao.UsersRepository;
import com.hqj.pojo.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl userDaoImpl;

	@Autowired
	private UsersRepository usersRepository;

	public void addUser() {
		this.userDaoImpl.saveUser();
	}

	@Override
	// @Cacheable:对当前查询的对象做缓存处理
	// myUsersCache：ehcache.xml中自定义的缓存策略
	@Cacheable(value = "myUsersCache")
	public Users findUsersById(Integer id) {
		return usersRepository.findOne(id);
	}

	@Override
	// key = "#pageable"：缓存的key是pageable，ehcache会以这个
	// key去查找缓存，默认就是pageable做为key
//	@Cacheable(value = "myUsersCache", key = "#pageable")
	// key = "#pageable.pageSize"：以pageable对象里面的pageSize属性作为key查询缓存
	@Cacheable(value = "myUsersCache", key = "#pageable.pageSize")
	public Page<Users> findUsersPage(Pageable pageable) {
		return usersRepository.findAll(pageable);
	}

	@Override
	@Cacheable(value = "myUsersCache")
	public List<Users> findUsersAll() {
		return usersRepository.findAll();
	}

	@Override
	//清除myUsersCache缓存策略
	@CacheEvict(value = "myUsersCache", allEntries = true)
	public void saveUsers(Users users) {
		usersRepository.save(users);
	}
}
