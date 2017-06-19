package com.cycleon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cycleon.model.LeaveRequest;
import com.cycleon.service.LeaveRequestService;

@RestController
public class LeaveRequestController {
	@Autowired
	private LeaveRequestService levReqService;
	
	@RequestMapping(method=RequestMethod.POST, value="/leaveReq")
	public List<LeaveRequest> addLeaveReq(@RequestBody LeaveRequest levReq){
				return levReqService.addLeaveRequest(levReq);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/leaveReq/{id}")
	public String deleteLeavReq(@PathVariable int id){
		return levReqService.deleteLeaveRequest(id);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/leaveReq/{id}")
	public String updateLeavReq(@RequestBody LeaveRequest levReq){
		return levReqService.updateLeaveRequest(levReq);
	}
	@RequestMapping(method=RequestMethod.GET,value="/leaveReq")
	public List<LeaveRequest> getAllLeaveRequest(){
		return levReqService.getAllLeaveRequest();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/leaveReq/{employeeId}")
	public List<LeaveRequest> getLeaveRequest(@PathVariable int employeeId){
		return levReqService.getByEmployee(employeeId);
	}
}
