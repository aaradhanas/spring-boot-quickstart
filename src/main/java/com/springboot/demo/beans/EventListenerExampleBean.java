package com.springboot.demo.beans;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class EventListenerExampleBean {

    private static final Logger LOGGER = Logger.getLogger(EventListenerExampleBean.class.getName());

    @EventListener
    public void onApplicationStartEvent(ContextRefreshedEvent contextRefreshedEvent) {
        LOGGER.info("contextRefreshedEvent = " + contextRefreshedEvent.getApplicationContext());
    }

    @EventListener
    public void onApplicationStopEvent(ContextClosedEvent contextClosedEvent) {
        LOGGER.info("contextClosedEvent = " + contextClosedEvent.getApplicationContext());
    }
}
