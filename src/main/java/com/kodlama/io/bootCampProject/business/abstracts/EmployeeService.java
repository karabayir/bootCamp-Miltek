package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.CreateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.GetEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateEmployeeResponse;

public interface EmployeeService {

	List<GetAllEmployeeResponse> getAll();
	
	List<GetAllEmployeeResponse> getByName(String name);
	
	GetEmployeeResponse getById(int id);
	
	CreateEmployeeResponse add(CreateEmployeeRequest request);
	
	UpdateEmployeeResponse update(UpdateEmployeeRequest request);
	
	void delete(int id);
}
