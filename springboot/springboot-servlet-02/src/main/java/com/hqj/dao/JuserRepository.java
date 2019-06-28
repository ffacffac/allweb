package com.hqj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hqj.pojo.JUser;

/**
 * 用户和角色一对多关联关系
 *
 */
public interface JuserRepository extends JpaRepository<JUser, Integer> {

}
