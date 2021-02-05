package com.springboot.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

public class InitMethodExampleBean {

    private static final Logger LOG = Logger.getLogger(InitMethodExampleBean.class.getName());

    @Autowired
    private Environment environment;

    public void init() {
        LOG.info("InitMethodExampleBean init = " +environment);
    }

    @PostConstruct
    public void postConstruct() {
        LOG.info("InitMethodExampleBean init");
    }

    @Bean(initMethod = "init")
    public InitMethodExampleBean initMethodExampleBean() {
        return new InitMethodExampleBean();
    }
}
