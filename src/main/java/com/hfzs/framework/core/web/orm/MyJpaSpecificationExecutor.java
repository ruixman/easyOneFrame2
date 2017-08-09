package com.hfzs.framework.core.web.orm;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * JPA Specification Executor
 * 
 * @author liufang
 * 
 * @param <T>
 */
public interface MyJpaSpecificationExecutor<T> extends
		JpaSpecificationExecutor<T> {
	List<T> findAll(Specification<T> spec, Limitable limitable);
}
