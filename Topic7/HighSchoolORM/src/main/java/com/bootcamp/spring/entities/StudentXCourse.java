package com.bootcamp.spring.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student_x_course", catalog = "high_school")
public class StudentXCourse {

	private StudentXCourseId id;
	private Integer note1;
	private Integer note2;
	private Integer note3;
	private Integer finalNote;

	public StudentXCourse() {
	}

	public StudentXCourse(StudentXCourseId id) {
		this.id = id;
	}

	public StudentXCourse(StudentXCourseId id, Integer note1, Integer note2,
			Integer note3, Integer finalNote) {
		this.id = id;
		this.note1 = note1;
		this.note2 = note2;
		this.note3 = note3;
		this.finalNote = finalNote;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idStudent", column = @Column(name = "id_student", nullable = false)),
			@AttributeOverride(name = "idCourse", column = @Column(name = "id_course", nullable = false)) })
	public StudentXCourseId getId() {
		return this.id;
	}

	public void setId(StudentXCourseId id) {
		this.id = id;
	}

	@Column(name = "note_1")
	public Integer getNote1() {
		return this.note1;
	}

	public void setNote1(Integer note1) {
		this.note1 = note1;
	}

	@Column(name = "note_2")
	public Integer getNote2() {
		return this.note2;
	}

	public void setNote2(Integer note2) {
		this.note2 = note2;
	}

	@Column(name = "note_3")
	public Integer getNote3() {
		return this.note3;
	}

	public void setNote3(Integer note3) {
		this.note3 = note3;
	}

	@Column(name = "final_note")
	public Integer getFinalNote() {
		return this.finalNote;
	}

	public void setFinalNote(Integer finalNote) {
		this.finalNote = finalNote;
	}
}