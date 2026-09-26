package com.example.spring.demo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FootballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "50 penalty shootouts";
    }
}
