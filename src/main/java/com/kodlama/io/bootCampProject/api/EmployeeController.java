package com.kodlama.io.bootCampProject.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.bootCampProject.business.abstracts.EmployeeService;
import com.kodlama.io.bootCampProject.business.requests.CreateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.GetEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.GetEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateEmployeeResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/employees/")
@AllArgsConstructor
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@GetMapping("getAll")
	public DataResult<List<GetAllEmployeeResponse>>  getAll(){
		return employeeService.getAll();
	}
	
	@GetMapping("getAllByName")
	public DataResult<List<GetAllEmployeeResponse>>  getByName(@Valid @RequestBody GetEmployeeRequest request){
		return employeeService.getByName(request);
	}
	
	@GetMapping("getById/{id}")
	public DataResult<GetEmployeeResponse>  getById(@PathVariable int id) {
		return employeeService.getById(id);
	}
	
	@PostMapping("add")
	public DataResult<CreateEmployeeResponse>  add(@Valid @RequestBody CreateEmployeeRequest request) {
		return employeeService.add(request);
	}
	
	@PutMapping("update")
	public DataResult<UpdateEmployeeResponse>  update(@Valid @RequestBody UpdateEmployeeRequest request) {
		return employeeService.update(request);
	}
	
	@DeleteMapping("deleteById/{id}")
	public Result delete(@PathVariable int id) {
		 return employeeService.delete(id);
	}
}
