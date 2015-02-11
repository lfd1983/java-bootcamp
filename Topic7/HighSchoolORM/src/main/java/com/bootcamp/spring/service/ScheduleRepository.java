package com.bootcamp.spring.service;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.spring.entities.Schedule;

public interface ScheduleRepository extends CrudRepository<Schedule, Serializable>{

}
