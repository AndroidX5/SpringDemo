package com.example.spring.demo.config;

import com.example.spring.demo.common.Coach;
import com.example.spring.demo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwimConfig {

    @Bean("aqua")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
