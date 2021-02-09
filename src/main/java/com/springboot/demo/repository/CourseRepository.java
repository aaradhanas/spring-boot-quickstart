package com.springboot.demo.repository;

import com.springboot.demo.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {

    //findBy<property_name>
    List<Course> findByName(String name);
    List<Course> findByDescription(String description);

    List<Course> findByTopicId(String topicId);
}
