package com.ness.BankingAssistant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder getencoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService users(PasswordEncoder encoder) {
        UserDetails user = User.builder()
                .username("TESTUSER")
                .password(encoder.encode("TESTUSER"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("TESTADMIN")
                .password(encoder.encode("TESTADMIN"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http)
            throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/api/health**")
                        .permitAll()

                        .requestMatchers(
                                "/api/enquiries/classify",
                                "//api/enquiries/summarize", "/api/assistant/ask")
                        .hasAnyRole(
                                "USER")

                        .requestMatchers(
                                "/api/assistant/audit")
                        .hasRole(
                                "ADMIN")
                        .anyRequest()
                        .authenticated()
                )

                .httpBasic(
                        Customizer.withDefaults());

        return http.build();
    }
}
