package com.bootcamp.spring.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bootcamp.spring.entities.Course;
import com.bootcamp.spring.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Serializable>{
	
	@Query(value = "SELECT C FROM course WHERE student_x_course.id_student = ?0 AND student_x_course.id_course=c.id_course", nativeQuery = true)
	List<Course> findCoursesByStudent(int id);
}
