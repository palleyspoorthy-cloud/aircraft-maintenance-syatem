package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**").permitAll() // Unlocks local asset files
                .anyRequest().permitAll() // Permits all UI routing panels to read styles freely
            )
            .csrf(csrf -> csrf.disable()); // Disables cross-site request tokens for clean local testing

        return http.build();
    }
}
