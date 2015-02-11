package com.bootcamp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.spring.entities.Course;
import com.bootcamp.spring.service.CourseRepository;

@RestController
@RequestMapping(value="/api")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public Iterable<Course> allCourse(){
		return courseRepository.findAll();
	}
	
	@RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
	public Course findById(@PathVariable int id){
		return courseRepository.findOne(id);
	}
	
	@RequestMapping(value = "/course/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable int id, @RequestBody Course course){
		Course rx = courseRepository.findOne(id);
		if(rx == null){
			throw new IllegalStateException("No course with id: " + id);
		}
			course.setIdCourse(rx.getIdCourse());
			courseRepository.save(course);
	}
}
