package com.bootcamp.spring.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "course_x_schedule")
public class CourseXSchedule {

	private CourseXScheduleId id;
	private Integer totalHours;

	public CourseXSchedule() {
	}

	public CourseXSchedule(CourseXScheduleId id) {
		this.id = id;
	}

	public CourseXSchedule(CourseXScheduleId id, Integer totalHours) {
		this.id = id;
		this.totalHours = totalHours;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idCourse", column = @Column(name = "id_course", nullable = false)),
			@AttributeOverride(name = "idSchedule", column = @Column(name = "id_schedule", nullable = false)) })
	public CourseXScheduleId getId() {
		return this.id;
	}

	public void setId(CourseXScheduleId id) {
		this.id = id;
	}

	@Column(name = "total_hours")
	public Integer getTotalHours() {
		return this.totalHours;
	}

	public void setTotalHours(Integer totalHours) {
		this.totalHours = totalHours;
	}
}