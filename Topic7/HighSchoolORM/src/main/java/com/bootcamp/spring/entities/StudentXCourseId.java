package com.bootcamp.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Embeddable
public class StudentXCourseId implements Serializable {

	@NotNull
	@Column(name = "id_student")
	private int idStudent;

	@NotNull
	@Column(name = "id_course")
	private int idCourse;

	public StudentXCourseId() {
	}

	public StudentXCourseId(int idStudent, int idCourse) {
		this.idStudent = idStudent;
		this.idCourse = idCourse;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) idStudent;
		hash += (int) idCourse;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof StudentXCourseId)) {
			return false;
		}
		StudentXCourseId other = (StudentXCourseId) object;
		if (this.idStudent != other.idStudent) {
			return false;
		}
		if (this.idCourse != other.idCourse) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.prueba.entities.StudentXCoursePK[ idStudent=" + idStudent
				+ ", idCourse=" + idCourse + " ]";
	}
}