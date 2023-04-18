package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Modules.CustomEmployeeDetail;
import com.example.demo.Modules.Employee;
import com.example.demo.Repository.EmployeeRepository;

@Service
public class CustomEmployeeDetailService implements UserDetailsService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		
		Employee emp = employeeRepository.findByName(username);
		if(emp==null)
		{
			throw new UsernameNotFoundException("No User");
		}
		
		return new CustomEmployeeDetail(emp);
	}

}
