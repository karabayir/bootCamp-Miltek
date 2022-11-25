package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.CreateBootcampsRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateBootcampsRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateBootcampsResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllBootcampsResponse;
import com.kodlama.io.bootCampProject.business.responses.GetBootcampsResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateBootcampsResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

public interface BootcampsService {

	DataResult<List<GetAllBootcampsResponse>>  getAll();
	
	DataResult<GetBootcampsResponse>  getById(int id);
	
	DataResult<CreateBootcampsResponse>  add(CreateBootcampsRequest request);
	
	DataResult<UpdateBootcampsResponse> update(UpdateBootcampsRequest request);
	
	Result delete(int id);
	
	void checkIfBootcampIsActive(int id);
	
}
