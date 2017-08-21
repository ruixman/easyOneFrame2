package com.hfzs.framework.core.web;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.hfzs.framework.core.web.orm.MyJpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EntityScan({"com.hfzs.biz.sys.domain"})
@EnableJpaRepositories(basePackages = {"com.hfzs.biz.sys.repository"}, repositoryFactoryBeanClass = MyJpaRepositoryFactoryBean.class)
@ComponentScan({"com.hfzs.biz.sys.service.impl", "com.hfzs.biz.sys.controller"})
class ContextConfig {

}
