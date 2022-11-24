package com.kodlama.io.bootCampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.EmployeeService;
import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.business.requests.CreateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.GetEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.GetEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateEmployeeResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlama.io.bootCampProject.entities.users.Employee;
import com.kodlama.io.bootCampProject.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService{

	private final EmployeeRepository employeeRepository;
	private final ModelMapperService mapperService;
	
	@Override
	public DataResult<List<GetAllEmployeeResponse>>  getAll() {
		List<GetAllEmployeeResponse> response= employeeRepository.findAll()
				.stream()
				.map(e-> mapperService.forResponse().map(e, GetAllEmployeeResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllEmployeeResponse>>(response, "getAll");
	}
	
	@Override
	public DataResult<List<GetAllEmployeeResponse>>  getByName(GetEmployeeRequest request) {
		List<Employee> employee = employeeRepository.findByFirstName(request.getFirstName());
		List<GetAllEmployeeResponse> response = employee
				.stream()
				.map(e-> mapperService.forResponse().map(e, GetAllEmployeeResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllEmployeeResponse>>(response,"findByName");
	}

	@Override
	public DataResult<GetEmployeeResponse> getById(int id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new BusinessException(id+Messages.EmployeeIdException));
		GetEmployeeResponse response= mapperService.forResponse().map(employee, GetEmployeeResponse.class);
		return new SuccessDataResult<GetEmployeeResponse>(response, "findById");
	}

	@Override
	public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest request) {
		Employee employee = mapperService.forRequest().map(request, Employee.class);
		checkIfApplicantExistByNationalIdentity(request.getNationalIdentity());
		employeeRepository.save(employee);
		CreateEmployeeResponse result =  mapperService.forResponse().map(employee, CreateEmployeeResponse.class);
		return new SuccessDataResult<CreateEmployeeResponse>(result, Messages.EmployeeCreated);
	}

	@Override
	public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest request) {
		Employee employee = mapperService.forRequest().map(request, Employee.class);
		checkIfEmployeeExistById(request.getId());
		checkIfApplicantExistByNationalIdentity(request.getNationalIdentity());
		employeeRepository.save(employee);
		UpdateEmployeeResponse response= mapperService.forResponse().map(employee, UpdateEmployeeResponse.class);
		return new SuccessDataResult<UpdateEmployeeResponse>(response, Messages.EmployeeUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfEmployeeExistById(id);
		employeeRepository.deleteById(id);	
		return new SuccessResult(Messages.EmployeeDeleted);
	}

	private void checkIfApplicantExistByNationalIdentity(String identity) {
		if(employeeRepository.findByNationalIdentity(identity) != null)
			throw new BusinessException(identity+ Messages.EmloyeeNationalIdentityException);
	}
	
	private void checkIfEmployeeExistById(int id) {
		if(employeeRepository.getEmployeeById(id) == null)
			throw new BusinessException(id+ Messages.EmployeeIdException);
	}
}
