package com.bootcamp.spring.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_teacher", unique = true, nullable = false)
	private Integer idTeacher;
	
	@Column(name = "first_name_teacher", nullable = false, length = 35)
	private String firstNameTeacher;
	
	@Column(name = "last_name_teacher", nullable = false, length = 35)
	private String lastNameTeacher;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date_teacher", nullable = false, length = 10)
	private Date birthDateTeacher;

	public Teacher() {
	}

	public Teacher(String firstNameTeacher, String lastNameTeacher,
			Date birthDateTeacher) {
		this.firstNameTeacher = firstNameTeacher;
		this.lastNameTeacher = lastNameTeacher;
		this.birthDateTeacher = birthDateTeacher;
	}

	public Integer getIdTeacher() {
		return this.idTeacher;
	}

	public void setIdTeacher(Integer idTeacher) {
		this.idTeacher = idTeacher;
	}

	public String getFirstNameTeacher() {
		return this.firstNameTeacher;
	}

	public void setFirstNameTeacher(String firstNameTeacher) {
		this.firstNameTeacher = firstNameTeacher;
	}

	public String getLastNameTeacher() {
		return this.lastNameTeacher;
	}

	public void setLastNameTeacher(String lastNameTeacher) {
		this.lastNameTeacher = lastNameTeacher;
	}
	
	public Date getBirthDateTeacher() {
		return this.birthDateTeacher;
	}

	public void setBirthDateTeacher(Date birthDateTeacher) {
		this.birthDateTeacher = birthDateTeacher;
	}
}