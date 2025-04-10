package com.example.todo_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for testing (Enable in production)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/tasks/**").permitAll() // Allow all access to /tasks endpoints
                        .anyRequest().authenticated() // Require authentication for other endpoints
                )
                .httpBasic(); // Enable basic authentication

        return http.build();
    }
}
