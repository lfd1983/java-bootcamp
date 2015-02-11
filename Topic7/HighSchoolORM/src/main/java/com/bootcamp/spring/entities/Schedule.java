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
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_schedule", unique = true, nullable = false)
	private Integer idSchedule;
	
	@NotNull
	@Column(name = "day", length = 9)
	private String day;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "time_from", nullable = false, length = 8)
	private Date timeFrom;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "time_to", nullable = false, length = 8)
	private Date timeTo;

	public Schedule() {
	}

	public Schedule(String day, Date timeFrom, Date timeTo) {
		this.day = day;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
	}

	public Integer getIdSchedule() {
		return this.idSchedule;
	}

	public void setIdSchedule(Integer idSchedule) {
		this.idSchedule = idSchedule;
	}

	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Date getTimeFrom() {
		return this.timeFrom;
	}

	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}

	public Date getTimeTo() {
		return this.timeTo;
	}

	public void setTimeTo(Date timeTo) {
		this.timeTo = timeTo;
	}

//	public Set<CourseXSchedule> getCourseXSchedule() {
//		return courseXSchedule;
//	}
//
//	public void setCourseXSchedule(Set<CourseXSchedule> courseXSchedule) {
//		this.courseXSchedule = courseXSchedule;
//	}
}