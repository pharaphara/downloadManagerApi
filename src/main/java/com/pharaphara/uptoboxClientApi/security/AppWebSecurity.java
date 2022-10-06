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
        //log.info("username {}, ",username);

       http
               .csrf().disable()
               .authorizeHttpRequests()
               .anyRequest()
               .authenticated()

               .and()
               .httpBasic()
               ;

       return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        //log.info("username {}, ",username);
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        String encodedPassword = passwordEncoder().encode(password);
//        manager.createUser(User.withUsername(username).password(encodedPassword).roles("USER").build());
//        return manager;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}