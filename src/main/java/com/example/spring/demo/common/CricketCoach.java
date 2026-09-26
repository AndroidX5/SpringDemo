package com.example.spring.demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor " + getClass().getSimpleName());
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("In post construct of " + getClass().getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("In pre destroy of " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 mins";
    }
}
