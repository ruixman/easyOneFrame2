package com.hfzs.framework.core.web.orm;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * QueryDsl Predicate Executor
 * 
 * @author liufang
 * 
 * @param <T>
 */
public interface MyQueryDslPredicateExecutor<T> extends
		QueryDslPredicateExecutor<T> {

	List<T> findAll(Predicate predicate, Sort sort);

	List<T> findAll(Predicate predicate, Limitable limitable);
}
