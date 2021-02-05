package com.springboot.demo.service;

import com.springboot.demo.controller.CourseController;
import com.springboot.demo.model.Course;
import com.springboot.demo.model.Topic;
import com.springboot.demo.repository.CourseRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId) {
        return courseRepository.findByTopicId(topicId);
    }

    public Course getCourse(String id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        return courseOptional.isPresent() ? courseOptional.get(): new Course();
    }

    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(String id, Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
