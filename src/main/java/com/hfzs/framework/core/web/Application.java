package com.hfzs.framework.core.web;

import com.hfzs.framework.Constants;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.mobile.DeviceResolverAutoConfiguration;
import org.springframework.boot.autoconfigure.mobile.SitePreferenceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.*;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/21.
 */
@Configuration
// 此三项也未用到，但二次开发时有可能会用到，暂时不屏蔽：JdbcTemplateAutoConfiguration.class, JtaAutoConfiguration.class,
// WebSocketAutoConfiguration.class
// 暂时不用Mobile的自动配置：DeviceResolverAutoConfiguration.class, SitePreferenceAutoConfiguration.class
@EnableAutoConfiguration(exclude = { MessageSourceAutoConfiguration.class, JmxAutoConfiguration.class,
        CacheAutoConfiguration.class, DeviceResolverAutoConfiguration.class, SitePreferenceAutoConfiguration.class })
@Import({ ContextConfig.class})
@PropertySource({ "classpath:conf/spring.jpa.properties" })
@ImportResource({ "classpath:conf/**/context*.xml" })
@SpringBootApplication
public class Application  extends SpringBootServletInitializer implements WebApplicationInitializer {
    /**
     * war方式启动的处理方法
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return configureApplication(builder);
    }

    /**
     * jar方式启动的处理方法
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        configureApplication(new SpringApplicationBuilder()).run(args);
    }

    /**
     * war方式启动和jar方式启动共用的配置
     *
     * @param builder
     * @return
     */
    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(Application.class).listeners(
            new ApplicationListener<ApplicationEnvironmentPreparedEvent>() {
                // 在应用环境准备好后执行（Application.properties和PoropertySource已读取），此时BeanFactory还未准备好（Bean还未创建）
                @Override
                public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
                    ConfigurableEnvironment env = event.getEnvironment();
                    // 用配置文件中的内容覆盖替代Constants的内容
                    Constants.loadEnvironment(env);
                }
            });
    }

    /**
     * 注册类型转换器。主要包括日期转换器和字符串转换器。
     *
     * @return
//     */
    @Bean
    public ConfigurableWebBindingInitializer configurableWebBindingInitializer() {
        ConfigurableWebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
        PropertyEditorRegistrar registrar = new PropertyEditorRegistrar() {
            @Override
            public void registerCustomEditors(PropertyEditorRegistry registry) {
                registry.registerCustomEditor(Date.class, new DateEditor());
                registry.registerCustomEditor(String.class, new StringEmptyEditor());
            }
        };
        initializer.setPropertyEditorRegistrar(registrar);
        return initializer;
    }

    @Configuration
    protected static class WebConfig extends WebMvcConfigurerAdapter {
//        @Bean
//        public ForeInterceptor foreInterceptor() {
//            return new ForeInterceptor();
//        }
//
//        @Override
//        public void addInterceptors(InterceptorRegistry registry) {
//            registry.addInterceptor(new TimerInterceptor());
//            registry.addInterceptor(foreInterceptor()).excludePathPatterns("/error/**");
//            super.addInterceptors(registry);
//        }
    }
}
