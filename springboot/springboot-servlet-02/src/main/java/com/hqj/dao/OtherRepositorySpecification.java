package com.hqj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hqj.pojo.Other;

/**
 * JpaSpecificationExecutor
 *
 */
public interface OtherRepositorySpecification extends JpaRepository<Other, Integer>, JpaSpecificationExecutor<Other> {

}
