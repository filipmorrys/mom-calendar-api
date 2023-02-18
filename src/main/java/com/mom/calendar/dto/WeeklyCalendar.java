package com.mom.calendar.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class WeeklyCalendar implements Serializable {
  
  private static final long serialVersionUID = 1L;

  @Id
  private String id;
  
  private String name;
  
  @OneToMany(cascade = {CascadeType.ALL})
  private List<Day> days;

  
  public WeeklyCalendar() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Day> getDays() {
    return days;
  }

  public void setDays(List<Day> days) {
    this.days = days;
  }

  @Override
  public String toString() {
    return "WeeklyCalendar [id=" + id + ", name=" + name + ", days=" + days + "]";
  }

}
