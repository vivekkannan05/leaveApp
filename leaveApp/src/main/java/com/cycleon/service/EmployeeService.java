package com.cycleon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cycleon.jpa.EmployeeRepository;
import com.cycleon.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	public List<Employee> getAllEmployeeList() {
		return (List<Employee>) empRepo.findAll();
	}

	public Employee getEmployee(String email) {
		Employee emp =empRepo.findByNameIgnoreCase(email);
		return emp;
	}
	
	public Employee addEmployee(Employee emp){
		return empRepo.save(emp);
		
	}
	
	public Employee updateEmployee(Employee emp){
		return empRepo.save(emp);
	}
}
