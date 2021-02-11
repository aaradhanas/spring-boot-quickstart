package com.springboot.demo.controller;

import com.springboot.demo.config.Settings;
import com.springboot.demo.model.Topic;
import com.springboot.demo.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class TopicController {

    private final Logger logger = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    private TopicService topicService;

    @Autowired
    private Settings settings;

    @GetMapping("/topics")
    public List<Topic> getAllTopics(HttpServletRequest request) {
        // logger.info("Setttings flag = "+ settings.isEnabled());
        if(request.getSession(false) != null) {
            HttpSession session = request.getSession(false);
            logger.info("JSESSIONID = " + session.getId());
        } else {
            // TODO
        }
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @PostMapping("/topics")
    public void createTopic(@RequestBody Topic topic) {
        topicService.createTopic(topic);
    }

    @PutMapping("/topics/{id}")
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
        topicService.updateTopic(id, topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}
