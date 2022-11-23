package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.CreateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.GetEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.GetEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateEmployeeResponse;
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
