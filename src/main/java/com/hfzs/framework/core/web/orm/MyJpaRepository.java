package com.hfzs.framework.core.web.orm;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * JPA Repository 接口
 * 
 * @author ruix
 * 
 * @param <T>
 * @param <ID>
 */
public interface MyJpaRepository<T, ID extends Serializable> extends
		JpaRepository<T, ID> {
	List<T> findAll(Limitable limitable);
	public Page<T> findAll(Specification<T> spec, Pageable pageable);

//	@Override
//	public T save(Object o);

}
