package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private BCryptPasswordEncoder encoder;
	// quản lý ng sử dụng

	// must encode password
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// origin data
		auth.inMemoryAuthentication().withUser("user1").password(encoder.encode("123")).roles("GUEST").and()
				.withUser("user2").password(encoder.encode("123")).roles("USER", "GUEST").and().withUser("user3")
				.password(encoder.encode("123")).roles("ADMIN", "USER", "GUEST");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable().csrf().disable();
		// phân quyền
		http.authorizeHttpRequests().
		antMatchers("/home/admin").hasRole("ADMIN").
		antMatchers("/home/user").hasAnyRole("ADMIN","USER").
		antMatchers("/home/authenticated").hasAnyRole("ADMIN","USER","GUEST").
		antMatchers("/home/index","/home/login","/home/data/**").permitAll().
		anyRequest().authenticated();
		
//		http.httpBasic(); // chỉ định hộp thoại đăng nhập cơ bản khi chưa đăng nhập
		http.formLogin().
		loginPage("/home/login").
		loginProcessingUrl("/security/login").
		defaultSuccessUrl("/home/page", false).
		failureUrl("/home/login?error=true").
		usernameParameter("username").
		passwordParameter("password");
		
		http.exceptionHandling().accessDeniedPage("/access-denied");
		
		http.rememberMe().
		rememberMeParameter("remember");
		
		
		http.logout().logoutUrl("/home/logout").
		logoutSuccessUrl("/home/index").
		addLogoutHandler(new SecurityContextLogoutHandler());
//		http.logout().an
	}
}