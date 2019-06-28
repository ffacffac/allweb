package com.hqj.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hqj.pojo.Other;

/**
 * 参数一：当前需要映射的实体类； 参数二：当前映射实体类的ID类型
 * 
 * @author huangqj
 *
 */
public interface OtherRepository extends JpaRepository<Other, Integer> {

}
