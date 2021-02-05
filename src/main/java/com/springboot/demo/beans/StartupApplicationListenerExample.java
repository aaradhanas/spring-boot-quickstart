package com.springboot.demo.beans;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

// @Component
public class StartupApplicationListenerExample implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = Logger.getLogger(StartupApplicationListenerExample.class.getName());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        LOGGER.info("ContextRefreshedEvent = " + contextRefreshedEvent.getApplicationContext());
    }
}
