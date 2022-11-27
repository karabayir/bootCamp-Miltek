package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.instructor.CreateInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.instructor.GetInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.instructor.UpdateInstructorRequest;
import com.kodlama.io.bootCampProject.business.responses.instructor.CreateInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.instructor.GetAllInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.instructor.GetInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.instructor.UpdateInstructorResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

public interface InstructorService {

	 DataResult<List<GetAllInstructorResponse>> getAll();
	
	 DataResult<List<GetAllInstructorResponse>> findByName(GetInstructorRequest request);
	
	 DataResult<GetInstructorResponse>  findById(int id);
	
	 DataResult<CreateInstructorResponse>  add(CreateInstructorRequest request);
	
	 DataResult<UpdateInstructorResponse>  update(UpdateInstructorRequest request);
	
	 Result delete(int id);
	
}
