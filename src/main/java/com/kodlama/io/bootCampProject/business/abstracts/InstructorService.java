package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.CreateInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateInstructorRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.GetInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateInstructorResponse;

public interface InstructorService {

	List<GetAllInstructorResponse> getAll();
	
	List<GetAllInstructorResponse> findByName(String name);
	
	GetInstructorResponse findById(int id);
	
	CreateInstructorResponse add(CreateInstructorRequest request);
	
	UpdateInstructorResponse update(UpdateInstructorRequest request);
	
	void delete(int id);
	
}
