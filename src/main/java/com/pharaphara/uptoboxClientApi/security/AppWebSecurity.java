package com.pharaphara.uptoboxClientApi.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppWebSecurity  {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

       http
               .csrf().disable()
               .authorizeHttpRequests()
               .antMatchers( "/ping").permitAll()
               .antMatchers("/**").authenticated() // These urls are allowed by any authenticated user
               .and()
               .httpBasic()
               ;

       return http.build();
    }
}