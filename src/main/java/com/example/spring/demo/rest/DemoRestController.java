package com.example.spring.demo.rest;

import com.example.spring.demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    Coach myCoach;

    @Autowired
    public DemoRestController(@Qualifier("cricketCoach") Coach myCoach) {
        System.out.println("In constructor " + getClass().getSimpleName());
        this.myCoach = myCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
       return myCoach.getDailyWorkout();
    }
}
