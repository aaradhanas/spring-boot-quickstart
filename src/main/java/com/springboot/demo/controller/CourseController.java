package com.springboot.demo.controller;

import com.springboot.demo.model.Course;
import com.springboot.demo.model.Topic;
import com.springboot.demo.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    private final Logger logger = LoggerFactory.getLogger(CourseController.class);
    // private Log log = LogFactory.getLog(CourseController.class);

    @GetMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        logger.info("Get all courses");
        return courseService.getAllCourses(id);
    }

    @GetMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String topicId, @PathVariable String id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/topics/{topicId}/courses")
    public void createCourse(@PathVariable String topicId, @RequestBody Course course) {
        course.setTopic(new Topic(topicId,"", ""));
        courseService.createCourse(course);
    }

    @PutMapping("/topics/{topicId}/courses/{id}")
    public void updateCourse(@PathVariable String topicId, @PathVariable String id, @RequestBody Course course) {
        course.setTopic(new Topic(topicId,"", ""));
        courseService.updateCourse(id, course);
    }

    @DeleteMapping("/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String topicId, @PathVariable String id) {
        courseService.deleteCourse(id);
    }
}
