package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dtos.EmployeeRequest;
import com.example.demo.Modules.Employee;
import com.example.demo.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	
	@Autowired
	EmployeeService employeeService;
	
	
	@PostMapping("/add-employee")
	public String addEmployee(@RequestBody EmployeeRequest employeeRequest)
	{
		return employeeService.addEmployee(employeeRequest);
	}
	
	
	@GetMapping("/get-employee")
	public Employee getEmployee(@RequestParam int id)
	{
		return employeeService.getEmployee(id);
	}
	
	
	@GetMapping("/home")
	public String getMessage()
	{
		return "Hai welcome...";
	}
	
	
	@PutMapping("/update-password/{id}")
	public String updatePassword(@PathVariable int id, @RequestParam  String password)
	{
		return employeeService.updatePassword(id, password);
	}
	
	
	@PutMapping("/update-role/{id}")
	public String updateRole(@PathVariable int id, @RequestParam String role) {
		return employeeService.updateRole(id, role);
	}
	
	
	
	
	

}
