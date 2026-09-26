package com.example.spring.demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    public TennisCoach() {
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
        return "500 backhands";
    }
}
