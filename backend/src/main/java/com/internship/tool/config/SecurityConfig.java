package com.internship.tool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> {})   // ✅ IMPORTANT (fixes browser blocking)

            .authorizeHttpRequests(auth -> auth

                // allow frontend
                .requestMatchers(
                        "/login.html",
                        "/register.html",
                        "/admin.html",
                        "/dashboard.html",
                        "/favicon.ico"
                ).permitAll()

                // allow auth
                .requestMatchers("/api/auth/**").permitAll()

                // 🔥 EXPLICITLY allow PUT (VERY IMPORTANT)
                .requestMatchers(HttpMethod.PUT, "/api/requests/**").permitAll()

                // allow all request APIs
                .requestMatchers("/api/requests/**").permitAll()

                // everything else
                .anyRequest().permitAll()
            );

        return http.build();
    }
}