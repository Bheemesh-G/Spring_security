package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modules.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	public Employee findByName(String username);

}
