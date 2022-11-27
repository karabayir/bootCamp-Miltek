package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.employee.CreateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.employee.GetEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.employee.UpdateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.responses.employee.CreateEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.employee.GetAllEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.employee.GetEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.employee.UpdateEmployeeResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

public interface EmployeeService {

	DataResult<List<GetAllEmployeeResponse>>  getAll();
	
	DataResult<List<GetAllEmployeeResponse>>  getByName(GetEmployeeRequest request);
	
	DataResult<GetEmployeeResponse>  getById(int id);
	
	DataResult<CreateEmployeeResponse>  add(CreateEmployeeRequest request);
	
	DataResult<UpdateEmployeeResponse>  update(UpdateEmployeeRequest request);
	
	Result  delete(int id);
}
