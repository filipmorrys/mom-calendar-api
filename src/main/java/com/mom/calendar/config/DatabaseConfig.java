package com.mom.calendar.config;

import javax.sql.DataSource;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.mom.calendar.MomCalendarApiApplication;
import com.mom.calendar.dto.WeeklyCalendar;

/**
 * The Class DatabaseConfig.
 */
@Configuration
@EnableJpaRepositories(
  basePackageClasses = MomCalendarApiApplication.class,
  entityManagerFactoryRef = "momCalendarEntityManagerFactory"
)
public class DatabaseConfig {

  @Bean
  public LocalContainerEntityManagerFactoryBean momCalendarEntityManagerFactory(DataSource dataSource,
    EntityManagerFactoryBuilder builder) {

    return builder
        .dataSource(dataSource)
        .packages(WeeklyCalendar.class)
        .build();
  }

}
