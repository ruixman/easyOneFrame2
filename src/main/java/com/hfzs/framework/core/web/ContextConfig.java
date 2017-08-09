package com.hfzs.framework.core.web;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.hfzs.framework.core.web.orm.MyJpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EntityScan({"com.hfzs.framework.domain"})
@EnableJpaRepositories(basePackages = {"com.hfzs.framework.repository"}, repositoryFactoryBeanClass = MyJpaRepositoryFactoryBean.class)
@ComponentScan({"com.hfzs.framework.service.impl", "com.hfzs.framework.core.web.controller"})
class ContextConfig {

}
