package com.springboot.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Component
public class PostConstructExampleBean {

    private static final Logger LOGGER = Logger.getLogger(PostConstructExampleBean.class.getName());

    @Autowired
    Environment environment;

    @PostConstruct
    public void init() {
        LOGGER.info("PostConstructExampleBean init");
    }
}
