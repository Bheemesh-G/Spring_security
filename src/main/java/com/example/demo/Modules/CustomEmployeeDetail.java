package com.example.demo.Modules;

import java.util.Collection;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Service.EmployeeService;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomEmployeeDetail implements UserDetails{
	
	
	private Employee employee;


	public CustomEmployeeDetail(Employee employee) {
		super();
		this.employee = employee;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		HashSet<SimpleGrantedAuthority> set = new HashSet<>();
		set.add(new SimpleGrantedAuthority(employee.getRole()));
		
		return set;
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.employee.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.employee.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
