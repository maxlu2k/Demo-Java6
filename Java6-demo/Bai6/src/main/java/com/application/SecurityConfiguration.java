package com.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

//	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.authorizeHttpRequests().antMatchers("");
		return httpSecurity.build();
	}

}
