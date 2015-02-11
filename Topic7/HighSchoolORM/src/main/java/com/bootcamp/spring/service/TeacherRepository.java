package com.bootcamp.spring.service;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.spring.entities.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Serializable>{

}
