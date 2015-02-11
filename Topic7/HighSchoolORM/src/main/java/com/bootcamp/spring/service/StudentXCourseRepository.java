package com.bootcamp.spring.service;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.spring.entities.StudentXCourse;

public interface StudentXCourseRepository extends CrudRepository<StudentXCourse, Serializable>{

}