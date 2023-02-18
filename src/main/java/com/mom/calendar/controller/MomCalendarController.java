package com.mom.calendar.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mom.calendar.dao.MomCalendarRepository;
import com.mom.calendar.dto.WeeklyCalendar;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(value="mom/calendar/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MomCalendarController {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(MomCalendarController.class);

  
  @Autowired
  private MomCalendarRepository repository;

  @PostMapping("")
  public WeeklyCalendar save(@RequestBody WeeklyCalendar cal) {
    LOGGER.info("Salvando calendario {} ", cal);
    return repository.save(cal);
  }
  
  
  @GetMapping("/{id}")
  public ResponseEntity<WeeklyCalendar> getWeeklyCalendar(@PathVariable String id) {
    LOGGER.info("Obteniendo calendario por id {} ", id);
    Optional<WeeklyCalendar> cal = repository.findById(id);
    
    if (cal.isPresent()) {
      return new ResponseEntity<>(cal.get(), HttpStatus.OK);
    }
    
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    LOGGER.info("Borrando calendario {} ", id);
    repository.deleteById(id);
    return new ResponseEntity<Void>(HttpStatus.OK);
  }
}
