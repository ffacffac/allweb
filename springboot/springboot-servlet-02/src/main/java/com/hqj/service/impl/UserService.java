package com.hqj.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hqj.pojo.Users;

public interface UserService {

	Users findUsersById(Integer id);
	
	Page<Users> findUsersPage(Pageable pageable);
	
	List<Users> findUsersAll();
	
	void saveUsers(Users users);
}
