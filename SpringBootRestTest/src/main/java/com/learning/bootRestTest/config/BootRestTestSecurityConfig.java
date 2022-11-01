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
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();

		return http.build();
	}


	@Bean
	public InMemoryUserDetailsManager userDetailsService() 
	{
		UserVO u = userRepo.findById("u").orElse(new UserVO("usera", "passworda"));
		UserDetails user = User.withUsername(u.getUsername()).password("{noop}"+u.getPassword()).roles("USER").build();
		return new InMemoryUserDetailsManager(user);
	}
}