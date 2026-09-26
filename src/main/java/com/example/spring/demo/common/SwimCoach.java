package com.example.spring.demo.common;

public class SwimCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Swim 1000m meters";
    }
}
