//package com.pharaphara.downloadManagerApi.security;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.web.cors.CorsConfiguration;
//
//@EnableWebSecurity
//public class WebSecurity extends WebSecurityConfigurerAdapter {
//
////    @Value("${app.username}")
////    private String username;
////    @Value("${app.password}")
////    private String password;
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        //log.info("username {}, ",username);
////
////        http.sessionManagement().sessionCreationPolicy(
////                        SessionCreationPolicy.STATELESS)
////                .and()
////                .authorizeRequests()
////                .antMatchers("/**").permitAll() // These urls are allowed by any authenticated user
////                //.antMatchers("/**").au() // These urls are allowed by any authenticated user
////                .and()
////                .httpBasic();
////        http.csrf().disable();
////    }
//
////    @Bean
////    public UserDetailsService userDetailsService() {
////        //log.info("username {}, ",username);
////        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
////        String encodedPassword = passwordEncoder().encode(password);
////        manager.createUser(User.withUsername(username).password(encodedPassword).roles("USER").build());
////        return manager;
////    }
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//}