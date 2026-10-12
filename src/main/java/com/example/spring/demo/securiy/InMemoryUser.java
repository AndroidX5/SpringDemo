package com.example.spring.demo.securiy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class InMemoryUser {

    @Bean
    public InMemoryUserDetailsManager userDetails() {
        UserDetails sachin = User.builder()
                .username("sachin")
                .password("{noop}sachin")
                .roles("EMPLOYEE")
                .build();

        UserDetails megha = User.builder()
                .username("megha")
                .password("{noop}megha")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();


        return new InMemoryUserDetailsManager(sachin, megha, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer -> {
           configurer.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE");
            configurer.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE");
            configurer.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER");
            configurer.requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER");
            configurer.requestMatchers(HttpMethod.PATCH, "/api/employees/**").hasRole("MANAGER");
            configurer.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN");
        });

        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}
