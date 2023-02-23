package org.venus_teah_poketeam_casestudy.security.config;

import org.venus_teah_poketeam_casestudy.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomUserDetailsService customUDS;



    //PASSWORD ENCODER
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //AUTHENTICATION PROVIDER - DAO
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUDS);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    //SECURITY FILTER CHAIN
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http

                .authorizeHttpRequests(
                (requests) -> requests
//                        .requestMatchers("/api2/**").permitAll().anyRequest().anonymous()
//                        .requestMatchers("/homepage/**").permitAll().anyRequest().anonymous()
                        .requestMatchers(
                                 //so you can use restcontoller for postman
                                "/registration**",
                                "/login**",
                                "/scripts/**",
                                "/styles/**",
                                "/static/img/**").permitAll()
                .anyRequest().authenticated()
//                        .requestMatchers("/homepage/**").permitAll().anyRequest().anonymous()
                )
//                .sessionManagement().maximumSessions(1).expiredUrl("/login?expired")

                //CUSTOM LOGIN PAGE
                .formLogin((form) -> form
                        .loginPage("/login")
//                        .loginProcessingUrl("/login")
//                        .defaultSuccessUrl("/user/")
                        .permitAll())



                //LOGOUT
                .logout((logout) -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
//                        .permitAll())
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))


        ;

        return http.build();
    }
}
