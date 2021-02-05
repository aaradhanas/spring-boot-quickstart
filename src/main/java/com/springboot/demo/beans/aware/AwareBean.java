package com.springboot.demo.beans.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// @Component
public class AwareBean implements ApplicationContextAware, BeanNameAware, BeanFactoryAware, BeanPostProcessor,
        InitializingBean, DisposableBean {

    private String beanName;

    // 1
    public AwareBean() {
        System.out.println("AwareBean constuctor called");
    }

    // 2
    @Override
    public void setBeanName(String beanName) {
        System.out.println("setBeanName::Bean name defined in context = " + beanName);
        this.beanName = beanName;
    }

    // 3
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory::Bean is singleton = " + beanFactory.isSingleton(beanName));
    }

    // 4
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext::Bean definition names = " + Arrays.toString(applicationContext.getBeanDefinitionNames()));
    }

    // 5
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization = "+ beanName);
        return bean;
    }

    // 6
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    // 7
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization = "+ beanName);
        return bean;
    }

    // 8
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }
}
