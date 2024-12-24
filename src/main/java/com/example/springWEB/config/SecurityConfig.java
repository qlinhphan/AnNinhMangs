package com.example.springWEB.config;

import java.util.List;

import com.example.springWEB.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import com.example.springWEB.service.CustomUserDetailsService;

import jakarta.servlet.DispatcherType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Bean
        public HttpFirewall httpFirewall() {
                StrictHttpFirewall firewall = new StrictHttpFirewall();
                firewall.setAllowSemicolon(true); // Cho phép ký tự ;
                firewall.setAllowUrlEncodedDoubleSlash(true); // Cho phép //
                return firewall;
        }

        @Bean
        public AuthenticationSuccessHandler myAuthenticationSuccessHandlers() {
                return new MyAuthenticationSuccessHandler();
        }

        @Bean
        public PasswordEncoder encoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests(authorize -> authorize
                                                .dispatcherTypeMatchers(DispatcherType.FORWARD,
                                                                DispatcherType.INCLUDE)
                                                .permitAll()

                                                .requestMatchers("/", "/login", "/client/**", "/detail/**",
                                                                "/css/**", "/js/**", "/images/**", "/register")
                                                .permitAll()

                                                // .requestMatchers("/admin/**").hasRole("ADMIN")

                                                .anyRequest().authenticated())

                                .formLogin(formLogin -> formLogin
                                                .loginPage("/login")
                                                // .loginProcessingUrl("/login")
                                                .failureUrl("/login?error")
                                                .successHandler(myAuthenticationSuccessHandlers()) // authorization
                                                .permitAll())

                                .exceptionHandling(ex -> ex.accessDeniedPage("/access-deny")) // page not
                                // allowed
                                .rememberMe(reM -> reM.key("uniqueAndSecret").tokenValiditySeconds(86400))
                                .logout(logout -> logout.deleteCookies("JSESSIONID"));

                return http.build();
        }

        // =======

        // @Bean
        // public HttpFirewall httpFirewall() {
        // StrictHttpFirewall firewall = new StrictHttpFirewall();
        // firewall.setAllowSemicolon(true); // Cho phép ký tự ;
        // firewall.setAllowUrlEncodedDoubleSlash(true); // Cho phép //
        // return firewall;
        // }

        // @Bean
        // SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // http
        // .authorizeHttpRequests(authorize -> authorize
        // .dispatcherTypeMatchers(DispatcherType.FORWARD,
        // DispatcherType.INCLUDE)
        // .permitAll()
        // .requestMatchers("/", "/login", "/client/**", "/detail/**",
        // "/css/**", "/js/**", "/images/**", "/register")
        // .permitAll()
        // .requestMatchers("/admin/**").hasRole("ADMIN")
        // .anyRequest().authenticated())
        // .formLogin(formLogin -> formLogin
        // .loginPage("/login")
        // .failureUrl("/login?error=true")
        // .successHandler(myAuthenticationSuccessHandlers()) // authorization
        // .permitAll())
        // .exceptionHandling(ex -> ex.accessDeniedPage("/access-deny")); // page not
        // // allowed
        // // .rememberMe(reM -> reM.key("uniqueAndSecret").tokenValiditySeconds(86400))
        // // .logout(logout -> logout.deleteCookies("JSESSIONID"));
        // return http.build();
        // }

        // @Bean
        // public AuthenticationSuccessHandler myAuthenticationSuccessHandlers() {
        // return new MyAuthenticationSuccessHandler();
        // }

        // @Bean
        // public AuthenticationManager authenticationManager(HttpSecurity http) throws
        // Exception {
        // return http.getSharedObject(AuthenticationManagerBuilder.class)
        // .userDetailsService(customUserDetailsService())
        // .passwordEncoder(passwordEncoder())
        // .and()
        // .build();
        // }

        // @Bean
        // public CustomUserDetailsService customUserDetailsService() {
        // return new CustomUserDetailsService();
        // }

        // @Bean
        // public PasswordEncoder passwordEncoder() {
        // return new BCryptPasswordEncoder();
        // }

        // >>>>>>>9692e9935f 79 bc1dc379be354920d060c610f085
}