package com.bootcamp.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_course", unique = true, nullable = false)
	private Integer idCourse;

	
    @NotNull
    @Size(min = 1, max = 50)
	@Column(name = "name_course")
	private String nameCourse;
	
    @NotNull
	@Column(name = "hours_per_week", nullable = false)
	private int hoursPerWeek;
	
	@Column(name = "id_teacher")
	private Integer idTeacher;

	public Course() {
	}

	public Course(String nameCourse, int hoursPerWeek) {
		this.nameCourse = nameCourse;
		this.hoursPerWeek = hoursPerWeek;
	}

	public Course(String nameCourse, int hoursPerWeek, Integer idTeacher) {
		this.nameCourse = nameCourse;
		this.hoursPerWeek = hoursPerWeek;
		this.idTeacher = idTeacher;
	}

	public Integer getIdCourse() {
		return this.idCourse;
	}

	public void setIdCourse(Integer idCourse) {
		this.idCourse = idCourse;
	}

	public String getNameCourse() {
		return this.nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public int getHoursPerWeek() {
		return this.hoursPerWeek;
	}

	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public Integer getIdTeacher() {
		return this.idTeacher;
	}

	public void setIdTeacher(Integer idTeacher) {
		this.idTeacher = idTeacher;
	}
}