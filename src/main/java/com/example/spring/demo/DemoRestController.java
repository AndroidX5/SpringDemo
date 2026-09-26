package com.example.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    Coach myCoach;

    @Autowired // optional in case single dep?
    public DemoRestController(Coach coach) {
        myCoach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
       return myCoach.getDailyWorkout();
    }
}
