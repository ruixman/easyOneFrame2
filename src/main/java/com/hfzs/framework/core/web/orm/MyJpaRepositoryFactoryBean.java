package com.hfzs.framework.core.web.orm;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * JPA Repository 工厂类
 * 
 * @author liufang
 * 
 * @param <T>
 * @param <S>
 * @param <ID>
 */
public class MyJpaRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable> extends
		JpaRepositoryFactoryBean<T, S, ID> {
	public MyJpaRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
		super(repositoryInterface);
	}

	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new MyJpaRepositoryFactory(entityManager);
	}
}
