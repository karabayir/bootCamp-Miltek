package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.bootcamps.CreateBootcampsRequest;
import com.kodlama.io.bootCampProject.business.requests.bootcamps.UpdateBootcampsRequest;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.CreateBootcampsResponse;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.GetAllBootcampsResponse;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.GetBootcampsResponse;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.UpdateBootcampsResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.entities.Bootcamps;

public interface BootcampsService {

	DataResult<List<GetAllBootcampsResponse>>  getAll();
	
	DataResult<GetBootcampsResponse>  getById(int id);
	
	DataResult<CreateBootcampsResponse>  add(CreateBootcampsRequest request);
	
	DataResult<UpdateBootcampsResponse> update(UpdateBootcampsRequest request);
	
	Result delete(int id);
	
	Bootcamps getBootcampsById(int id);
	
	void checkIfBootcampsExistById(int id);
}
