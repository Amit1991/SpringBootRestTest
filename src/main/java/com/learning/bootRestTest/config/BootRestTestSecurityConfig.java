package com.learning.bootRestTest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.learning.bootRestTest.model.UserVO;
import com.learning.bootRestTest.repoistory.UserRepo;

@Configuration
public class BootRestTestSecurityConfig {
	
	@Autowired
	private UserRepo userRepo;
}