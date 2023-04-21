package com.example.demo.Controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dtos.EmployeeRequest;
import com.example.demo.Modules.Employee;
import com.example.demo.Service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	
	
//@RequestHeader String Authorization -- is used to expect a token	
	
	@Autowired
	EmployeeService employeeService;
	
	
	@PostMapping("/add-employee")
	public String addEmployee(@RequestBody EmployeeRequest employeeRequest,@RequestHeader String Authorization)
	{
		return employeeService.addEmployee(employeeRequest);
	}
	
	
	@GetMapping("/get/employee")
	public Employee getEmployee(@RequestParam int id)
	{
		return employeeService.getEmployee(id);
	}
	
	
	@GetMapping("/home")
	public String getMessage()
	{
		return "Hai welcome...";
	}
	
	
	@PutMapping("/employee/update/{id}")
	public String updatePassword(@PathVariable int id, @RequestParam  String password)
	{
		return employeeService.updatePassword(id, password);
	}
	
	
	@PutMapping("/employee/update-role/{id}")
	public String updateRole(@PathVariable int id, @RequestParam String role) {
		return employeeService.updateRole(id, role);
	}
	
	
	
	
	

}
