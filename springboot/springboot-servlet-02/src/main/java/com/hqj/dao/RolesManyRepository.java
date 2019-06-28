package com.hqj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hqj.pojo.Roles;

/**
 * Roles与Menus多对多关联关系
 *
 */
public interface RolesManyRepository extends JpaRepository<Roles, Integer> {

}
