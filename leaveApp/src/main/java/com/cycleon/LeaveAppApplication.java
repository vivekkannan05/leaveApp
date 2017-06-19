package com.cycleon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cycleon.model.Employee;
import com.cycleon.service.EmployeeService;

@SpringBootApplication
public class LeaveAppApplication {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LeaveAppApplication.class, args);
		System.out.println("INsert action");
		List<Employee> empList = new ArrayList<Employee>(Arrays.asList(new Employee(1, "Vivek","vivek.kannan@cycleon.com", "IT", 20),
							new Employee(2, "Abhijith", "abhijith@sbc.com", "OPS", 30)));
		EmployeeService empService = context.getBean(EmployeeService.class);
		empList.forEach(empService::addEmployee);
	}
}
