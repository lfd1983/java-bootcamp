package com.bootcamp.spring.service;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.spring.entities.Course;

public interface CourseRepository extends CrudRepository<Course, Serializable>{

}
