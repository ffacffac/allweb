package com.hqj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hqj.pojo.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{ 

}
