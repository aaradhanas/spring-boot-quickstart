package com.springboot.demo.beans.invalid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

// @Component
public class InvalidInitExampleBean {
    @Autowired
    Environment environment;

    public InvalidInitExampleBean() {
        System.out.println("InvalidInitExampleBean constructor");
        environment.getActiveProfiles();
    }
}
