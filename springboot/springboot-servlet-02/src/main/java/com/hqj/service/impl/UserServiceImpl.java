package com.hqj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
}
