package com.learning.bootRestTest.config;

import com.learning.bootRestTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class AppConfig {

    @Autowired
    private UserService userService;

    @Bean
    public UserDetailsService userDetailsService() {

        return username -> userService.getUserByUsername(username);
    }
}
