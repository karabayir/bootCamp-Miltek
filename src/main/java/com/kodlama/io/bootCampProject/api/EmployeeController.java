package com.kodlama.io.bootCampProject.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.bootCampProject.business.abstracts.EmployeeService;
import com.kodlama.io.bootCampProject.business.requests.CreateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.GetEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateEmployeeResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/employees/")
@AllArgsConstructor
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@GetMapping("getAll")
	public List<GetAllEmployeeResponse> getAll(){
		return employeeService.getAll();
	}
	
	@GetMapping("getAllByName")
	public List<GetAllEmployeeResponse> getByName(String name){
		return employeeService.getByName(name);
	}
	
	@GetMapping("getById/{id}")
	public GetEmployeeResponse getById(@PathVariable int id) {
		return employeeService.getById(id);
	}
	
	@PostMapping("add")
	public CreateEmployeeResponse add(CreateEmployeeRequest request) {
		return employeeService.add(request);
	}
	
	@PutMapping("update")
	public UpdateEmployeeResponse update(UpdateEmployeeRequest request) {
		return employeeService.update(request);
	}
	
	@DeleteMapping("deleteById/{id}")
	public void delete(@PathVariable int id) {
		 employeeService.delete(id);
	}
}
