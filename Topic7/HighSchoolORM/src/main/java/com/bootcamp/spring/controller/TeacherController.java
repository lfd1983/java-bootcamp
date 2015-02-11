package com.bootcamp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bootcamp.spring.entities.Teacher;
import com.bootcamp.spring.service.TeacherRepository;

public class TeacherController {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
	public Iterable<Teacher> allTeacher(){
		return teacherRepository.findAll();
	}
	
	@RequestMapping(value = "/teacher/{id}", method = RequestMethod.GET)
	public Teacher findById(@PathVariable int id){
		return teacherRepository.findOne(id);
	}
	
	@RequestMapping(value = "/teacher/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable int id, @RequestBody Teacher teacher){
		Teacher rx = teacherRepository.findOne(id);
		if(rx == null){
			throw new IllegalStateException("No teacher with id: " + id);
		}
			teacher.setIdTeacher(rx.getIdTeacher());
			teacherRepository.save(teacher);
	}
}
