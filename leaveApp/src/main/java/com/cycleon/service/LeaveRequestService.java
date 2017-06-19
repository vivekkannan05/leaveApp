package com.cycleon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cycleon.commons.LeaveRequestConstants;
import com.cycleon.jpa.EmployeeRepository;
import com.cycleon.jpa.LeaveRequestRepository;
import com.cycleon.model.Employee;
import com.cycleon.model.LeaveRequest;

/**
 * @author vivek
 *
 */
@Service
public class LeaveRequestService {
	@Autowired
	private LeaveRequestRepository leaveRepo;
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private EmployeeService empService;
	
	public List<LeaveRequest> addLeaveRequest(LeaveRequest levReq){
		try{
					
		leaveRepo.save(levReq);
		empService.updateEmployee(levReq.getEmployee());

		}catch (Exception e) {
			e.printStackTrace();
			//return LeaveRequestConstants.FAIL;
		}
		return getByEmployee(levReq.getEmployee().getId());
	}
	
	public String deleteLeaveRequest(int id){
			try{
			leaveRepo.delete(id);
			return LeaveRequestConstants.SUCCESS;
			}catch (Exception e) {
			return LeaveRequestConstants.FAIL;
			}
	}
	
	public List<LeaveRequest> getAllLeaveRequest(){
		return (List<LeaveRequest>) leaveRepo.findAll();
	}
	
	public String updateLeaveRequest(LeaveRequest levReq){
		try{
		leaveRepo.delete(levReq);
		return LeaveRequestConstants.SUCCESS;
		}catch (Exception e) {
		return LeaveRequestConstants.FAIL;
		}
	}
	
	public List<LeaveRequest> getByEmployee(int id){
		Employee emp = empRepo.findOne(id);
		return leaveRepo.findByEmployee(emp);
	}
}
