package com.unla.grupo6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//import com.unla.grupo6.services.implementation.UserService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Autowired
    @Qualifier("userService")
    //private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/css/", "/imgs/", "/js/", "/estacionamiento/**", "/baño/**", "/espacioverde/**", "/dispositivo/**", "/lucesautomaticas/**").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/loginprocess")
                .usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl("/loginsuccess").permitAll()
            .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/logout").permitAll();
        return http.build();
    }
}
    /* No usado en este ejemplo
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/images/", "/js/", "/webjars/*");
    }/
}

Enviar mensaje a ꜱᴀʟᴀ ᴅᴇ ᴇꜱᴛᴜᴅɪᴏ 1-🎓*/
