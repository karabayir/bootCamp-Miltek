package com.kodlama.io.bootCampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.InstructorService;
import com.kodlama.io.bootCampProject.business.requests.CreateInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateInstructorRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.GetInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateInstructorResponse;
import com.kodlama.io.bootCampProject.core.utilities.mapper.ModelMapperService;
import com.kodlama.io.bootCampProject.entities.users.Instructor;
import com.kodlama.io.bootCampProject.repository.InstructorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
	
	private final InstructorRepository instructorRepository;
	private final ModelMapperService mapperService;
	
	
	@Override
	public List<GetAllInstructorResponse> getAll() {
		return instructorRepository.findAll()
				.stream()
				.map(i-> mapperService.forResponse().map(i, GetAllInstructorResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<GetAllInstructorResponse> findByName(String name) {
		List<Instructor> instructors = instructorRepository.findByFirstName(name);
		return instructors
				.stream()
				.map(i-> mapperService.forResponse().map(i, GetAllInstructorResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public GetInstructorResponse findById(int id) {
		Instructor instructor = instructorRepository.findById(id).orElseThrow();
		return mapperService.forResponse().map(instructor, GetInstructorResponse.class);
	}

	@Override
	public CreateInstructorResponse add(CreateInstructorRequest request) {
		Instructor instructor = mapperService.forRequest().map(request, Instructor.class);
		instructor.setId(0);
		instructorRepository.save(instructor);
		return mapperService.forResponse().map(instructor, CreateInstructorResponse.class);
	}

	@Override
	public UpdateInstructorResponse update(UpdateInstructorRequest request) {
		Instructor instructor = mapperService.forRequest().map(request, Instructor.class);
		instructorRepository.save(instructor);
		return mapperService.forResponse().map(instructor, UpdateInstructorResponse.class);
	}

	@Override
	public void delete(int id) {
		instructorRepository.deleteById(id);
		
	}

	
}
