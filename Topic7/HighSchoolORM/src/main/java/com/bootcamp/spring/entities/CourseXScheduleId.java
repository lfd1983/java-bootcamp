package com.bootcamp.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@SuppressWarnings("serial")
@Embeddable
public class CourseXScheduleId implements Serializable{

    @NotNull
    @Column(name = "id_course")
    private int idCourse;
    
    @NotNull
    @Column(name = "id_schedule")
    private int idSchedule;
    
    public CourseXScheduleId() {
    }
    
    public CourseXScheduleId(int idCourse, int idSchedule) {
        this.idCourse = idCourse;
        this.idSchedule = idSchedule;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCourse;
        hash += (int) idSchedule;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseXScheduleId)) {
            return false;
        }
        CourseXScheduleId other = (CourseXScheduleId) object;
        if (this.idCourse != other.idCourse) {
            return false;
        }
        if (this.idSchedule != other.idSchedule) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prueba.entities.CourseXSchedulePK[ idCourse=" + idCourse + ", idSchedule=" + idSchedule + " ]";
    }
}