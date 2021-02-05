package com.springboot.demo.controller;

import com.springboot.demo.config.Settings;
import com.springboot.demo.model.Topic;
import com.springboot.demo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private Settings settings;

    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        System.out.println("Setttings flag = "+ settings.isEnabled());
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
