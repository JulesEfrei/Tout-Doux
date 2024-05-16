package com.efrei.toutdoux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/register", "/css/**", "/js/**", "/logout").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .failureUrl("/login?error=true")
                        .permitAll()
                        .defaultSuccessUrl("/tasks", true)
                )
                .logout(logout -> {
                    logout.logoutUrl("/logout")
                            .invalidateHttpSession(true)
                            .deleteCookies("JSESSIONID")
                            .logoutSuccessUrl("/login");
                });

        return http.build();
    }
}
