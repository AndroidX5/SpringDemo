package com.example.spring.demo.securiy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public UserDetailsManager userDetails(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetails() {
//        UserDetails sachin = User.builder()
//                .username("sachin")
//                .password("{noop}sachin")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails megha = User.builder()
//                .username("megha")
//                .password("{noop}megha")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}admin")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(sachin, megha, admin);
//    }

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
