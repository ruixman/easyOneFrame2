package com.hfzs.framework.core.web;

//import org.activiti.spring.SpringAsyncExecutor;
//import org.activiti.spring.SpringProcessEngineConfiguration;
//import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
//import org.activiti.spring.SpringAsyncExecutor;
//import org.activiti.spring.SpringProcessEngineConfiguration;
//import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.hfzs.framework.core.web.orm.MyJpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;


import javax.sql.DataSource;
import java.io.IOException;


@Configuration
@EntityScan({"com.hfzs.biz.*.domain"})
@EnableJpaRepositories(basePackages = {"com.hfzs.biz.*.repository"}, repositoryFactoryBeanClass = MyJpaRepositoryFactoryBean.class)
@ComponentScan({"com.hfzs.biz.*.service.impl", "com.hfzs.biz.*.controller","com.hfzs.biz.*.service"})
class ContextConfig {
}
