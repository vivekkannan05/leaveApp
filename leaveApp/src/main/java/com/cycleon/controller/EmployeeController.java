package com.cycleon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cycleon.model.Employee;
import com.cycleon.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
/*	
	@RequestMapping(method=RequestMethod.POST, value="/emp")
	public String addLeaveReq(@RequestBody LeaveRequest levReq){
				return empService.addLeaveRequest(levReq);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/emp/{id}")
	public String deleteLeavReq(@PathVariable int id){
		return empService.deleteLeaveRequest(id);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/emp/{id}")
	public String updateLeavReq(@RequestBody LeaveRequest levReq){
		return empService.
	}*/
	@RequestMapping(method=RequestMethod.GET,value="/emp")
	public List<Employee> getAllEmployeeEmailList(){
		return empService.getAllEmployeeList();
	}
	@RequestMapping(method=RequestMethod.GET,value="/emp/{email}")
	public Employee getEmployee(@PathVariable String email){
		return empService.getEmployee(email);
	}
	
}
