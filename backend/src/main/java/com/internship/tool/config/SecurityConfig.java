package com.internship.tool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF (required for APIs)
            .csrf(csrf -> csrf.disable())

            // Authorization rules
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/api/auth/**",        // ✅ allow login/register
                    "/api/requests/**",    // ✅ keep open for now (Day 4 APIs)
                    "/swagger-ui/**",      // ✅ swagger
                    "/v3/api-docs/**"      // ✅ swagger docs
                ).permitAll()

                // Any other API needs authentication
                .anyRequest().authenticated()
            );

        return http.build();
    }
}