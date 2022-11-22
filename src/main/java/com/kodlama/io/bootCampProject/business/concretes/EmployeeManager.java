package com.kodlama.io.bootCampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.EmployeeService;
import com.kodlama.io.bootCampProject.business.requests.CreateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.GetEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateEmployeeResponse;
import com.kodlama.io.bootCampProject.core.utilities.mapper.ModelMapperService;
import com.kodlama.io.bootCampProject.entities.users.Employee;
import com.kodlama.io.bootCampProject.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService{

	private final EmployeeRepository employeeRepository;
	private final ModelMapperService mapperService;
	
	@Override
	public List<GetAllEmployeeResponse> getAll() {
		return employeeRepository.findAll()
				.stream()
				.map(e-> mapperService.forResponse().map(e, GetAllEmployeeResponse.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<GetAllEmployeeResponse> getByName(String name) {
		List<Employee> employee = employeeRepository.findByFirstName(name);
		return employee
				.stream()
				.map(e-> mapperService.forResponse().map(e, GetAllEmployeeResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public GetEmployeeResponse getById(int id) {
		Employee employee = employeeRepository.findById(id).orElseThrow();
		return mapperService.forResponse().map(employee, GetEmployeeResponse.class);
	}

	@Override
	public CreateEmployeeResponse add(CreateEmployeeRequest request) {
		Employee employee = mapperService.forRequest().map(request, Employee.class);
		employee.setId(0);
		employeeRepository.save(employee);
		return mapperService.forResponse().map(employee, CreateEmployeeResponse.class);
	}

	@Override
	public UpdateEmployeeResponse update(UpdateEmployeeRequest request) {
		Employee employee = mapperService.forRequest().map(request, Employee.class);
		employeeRepository.save(employee);
		return mapperService.forResponse().map(employee, UpdateEmployeeResponse.class);
	}

	@Override
	public void delete(int id) {
		employeeRepository.deleteById(id);	
	}

}
