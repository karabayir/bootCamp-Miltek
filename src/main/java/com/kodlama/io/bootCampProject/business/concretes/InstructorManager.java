package com.kodlama.io.bootCampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.InstructorService;
import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.business.requests.CreateInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.GetInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateInstructorRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.GetInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateInstructorResponse;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlama.io.bootCampProject.entities.users.Instructor;
import com.kodlama.io.bootCampProject.repository.InstructorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
	
	private final InstructorRepository instructorRepository;
	private final ModelMapperService mapperService;
	
	
	@Override
	public DataResult<List<GetAllInstructorResponse>>  getAll() {
		
		List<GetAllInstructorResponse> response= instructorRepository.findAll()
				.stream()
				.map(i-> mapperService.forResponse().map(i, GetAllInstructorResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllInstructorResponse>>(response);
	}

	@Override
	public DataResult<List<GetAllInstructorResponse>> findByName(GetInstructorRequest request) {
		List<Instructor> instructors = instructorRepository.findByFirstName(request.getFirstName());
		
		List<GetAllInstructorResponse> response=  instructors
				.stream()
				.map(i-> mapperService.forResponse().map(i, GetAllInstructorResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllInstructorResponse>>(response, "findByName");
	}

	@Override
	public DataResult<GetInstructorResponse> findById(int id) {
		Instructor instructor = instructorRepository.findById(id).orElseThrow();
		GetInstructorResponse response= mapperService.forResponse().map(instructor, GetInstructorResponse.class);
		return new SuccessDataResult<GetInstructorResponse>(response, "findById");
	}

	@Override
	public DataResult<CreateInstructorResponse>  add(CreateInstructorRequest request) {
		Instructor instructor = mapperService.forRequest().map(request, Instructor.class);
		instructorRepository.save(instructor);
		CreateInstructorResponse response = mapperService.forResponse().map(instructor, CreateInstructorResponse.class);
		return new SuccessDataResult<CreateInstructorResponse>(response, Messages.InstructorCreated);
	}

	@Override
	public DataResult<UpdateInstructorResponse>  update(UpdateInstructorRequest request) {
		Instructor instructor = mapperService.forRequest().map(request, Instructor.class);
		instructorRepository.save(instructor);
		UpdateInstructorResponse response= mapperService.forResponse().map(instructor, UpdateInstructorResponse.class);
		return new SuccessDataResult<UpdateInstructorResponse>(response, Messages.InstructorUpdated);
	}

	@Override
	public Result delete(int id) {
		instructorRepository.deleteById(id);
	    return new SuccessResult(Messages.InstructorDeleted);
	}

}
