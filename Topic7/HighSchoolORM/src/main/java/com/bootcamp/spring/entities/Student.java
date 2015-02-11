package com.bootcamp.spring.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "student")
public class Student implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_student", unique = true, nullable = false)
	private int idStudent;
	
	@Column(name = "first_name_student", nullable = false, length = 35)
	private String firstNameStudent;
	
	@Column(name = "last_name_student", nullable = false, length = 35)
	private String lastNameStudent;
	

	private SimpleDateFormat ftDate = new SimpleDateFormat("yyyy-MM-dd");
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_day_student", nullable = false, length = 10)
	private Date birthDayStudent;

	public Student() {
	}

	public Student(String firstNameStudent, String lastNameStudent,
			Date birthDayStudent) {
		this.firstNameStudent = firstNameStudent;
		this.lastNameStudent = lastNameStudent;
		this.birthDayStudent = birthDayStudent;
	}
	
	public Student(String firstNameStudent, String lastNameStudent,
			String birthDayStudent) throws ParseException {
		this.firstNameStudent = firstNameStudent;
		this.lastNameStudent = lastNameStudent;
		this.birthDayStudent = ftDate.parse(birthDayStudent);
	}

	public int getIdStudent() {
		return this.idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	
	public String getFirstNameStudent() {
		return this.firstNameStudent;
	}

	public void setFirstNameStudent(String firstNameStudent) {
		this.firstNameStudent = firstNameStudent;
	}

	public String getLastNameStudent() {
		return this.lastNameStudent;
	}

	public void setLastNameStudent(String lastNameStudent) {
		this.lastNameStudent = lastNameStudent;
	}

	public Date getBirthDayStudent() {
		return this.birthDayStudent;
	}

	public void setBirthDayStudent(String birthDayStudent) throws ParseException {
		this.birthDayStudent = ftDate.parse(birthDayStudent);
	}
	
	public void setBirthDayStudent(Date birthDayStudent) {
		this.birthDayStudent = birthDayStudent;
	}
}

