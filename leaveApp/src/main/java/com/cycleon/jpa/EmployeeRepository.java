package com.cycleon.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cycleon.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
	

	public Employee findByEmail(String email);
	
	public Employee findByNameIgnoreCase(String name);
}
