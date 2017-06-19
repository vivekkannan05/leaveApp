package com.cycleon.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cycleon.model.Employee;
import com.cycleon.model.LeaveRequest;

@Repository
public interface LeaveRequestRepository extends CrudRepository<LeaveRequest,Integer> {

	public List<LeaveRequest> findByEmployee(Employee emp);
}
