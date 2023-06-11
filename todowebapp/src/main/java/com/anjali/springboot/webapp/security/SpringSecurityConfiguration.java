package com.anjali.springboot.webapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
    //LDAP or Database
    //In memory configure
//    InMemoryUserDetailsManager
//    InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public  InMemoryUserDetailsManager createUserDetailsManager() {
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);
        UserDetails userDetail = User.builder()
                                .passwordEncoder(passwordEncoder)
                                .username("anjali")
                                .password("dummy")
                                .roles("USER", "ADMIN")
                                .build();
        return  new InMemoryUserDetailsManager(userDetail);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
