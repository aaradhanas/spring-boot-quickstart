package com.springboot.demo.beans;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class InitializingBeanExampleBean implements InitializingBean {

    private static final Logger LOGGER = Logger.getLogger(InitializingBeanExampleBean.class.getName());

    @Autowired
    Environment environment;

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("afterPropertiesSet");
    }
}
