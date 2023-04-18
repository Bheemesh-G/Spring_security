package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Dtos.EmployeeRequest;
import com.example.demo.Modules.Employee;
import com.example.demo.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public String addEmployee(EmployeeRequest employeeRequest)
	{
		Employee emp = new Employee();
		emp.setName(employeeRequest.getName());
		emp.setRole(employeeRequest.getRole());
		
		employeeRepository.save(emp);
		
		return "Employee added";
		
	}
	
	
	public Employee getEmployee(int id)
	{
		return employeeRepository.findById(id).get();
	}
	
	public String updatePassword(int id,String password)
	{
		Employee emp = employeeRepository.findById(id).get();
		emp.setPassword(passwordEncoder.encode(password));
		
		employeeRepository.save(emp);
		
		
		return "Password Updated";
	}
	
	public String updateRole(int id,String role)
	{
		Employee emp = employeeRepository.findById(id).get();
		emp.setRole(role);
		employeeRepository.save(emp);
		
		return "Role of the Employee updated";
	}

}
