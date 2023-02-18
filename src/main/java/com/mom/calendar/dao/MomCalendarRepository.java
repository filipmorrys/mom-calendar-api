package com.mom.calendar.dao;

import org.springframework.data.repository.CrudRepository;

import com.mom.calendar.dto.WeeklyCalendar;


public interface MomCalendarRepository extends CrudRepository<WeeklyCalendar, String>{

}
