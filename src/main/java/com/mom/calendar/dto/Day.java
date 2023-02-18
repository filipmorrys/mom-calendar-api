package com.mom.calendar.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Day implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  private String id;
  
  private Integer index;
  
  private Date date;
  
  private String dayOfWeek;
  
  private String dayAndMonth;

  @ElementCollection
  private List<String> hours;
  
  public Day() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getIndex() {
    return index;
  }

  public Date getDate() {
    return date;
  }

  public List<String> getHours() {
    return hours;
  }
  
  public String getDayOfWeek() {
    return dayOfWeek;
  }

  public void setDayOfWeek(String dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }

  public String getDayAndMonth() {
    return dayAndMonth;
  }

  public void setDayAndMonth(String dayAndMonth) {
    this.dayAndMonth = dayAndMonth;
  }

  @Override
  public String toString() {
    return "Day [id=" + id + ", index=" + index + ", date=" + date + ", dayOfWeek=" + dayOfWeek + ", dayAndMonth="
        + dayAndMonth + ", hours=" + hours + "]";
  }

}
