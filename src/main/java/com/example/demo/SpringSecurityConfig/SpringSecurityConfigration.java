package com.example.demo.SpringSecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.Service.CustomEmployeeDetailService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigration {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	@Autowired
	private CustomEmployeeDetailService customEmployeeDetailService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		
		httpSecurity.csrf().disable()
		            .authorizeHttpRequests()
		            .requestMatchers("/employee/home").permitAll()
		            .requestMatchers("/employee/add-employee").hasRole("FRONTEND")
		            .anyRequest()
		            .authenticated()
		            .and()
		            .httpBasic();
		            
		            
		     return httpSecurity.build();       
		
		
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customEmployeeDetailService).passwordEncoder(passwordEncoder());
		
	}

}
