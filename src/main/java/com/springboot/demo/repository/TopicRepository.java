package com.springboot.demo.repository;

import com.springboot.demo.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
}
