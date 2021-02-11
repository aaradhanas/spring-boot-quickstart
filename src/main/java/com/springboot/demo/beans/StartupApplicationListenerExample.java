package com.springboot.demo.beans;

import com.springboot.demo.controller.TopicController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


// @Component
public class StartupApplicationListenerExample implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartupApplicationListenerExample.class.getName());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        LOGGER.info("ContextRefreshedEvent = " + contextRefreshedEvent.getApplicationContext());
        // LOGGER.info("topicControllerBean = " + contextRefreshedEvent.getApplicationContext().getBean(TopicController.class).getAllTopics());
    }
}
