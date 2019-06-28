package com.hqj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.hqj.pojo.Other;


/**
 * Repository @Query
 *
 */
public interface OtherRepositoryQueryAnnotation extends Repository<Other, Integer> {

	@Query(" from Other where State=?")
	List<Other> queryByStateUseHQL(Integer state);
}
