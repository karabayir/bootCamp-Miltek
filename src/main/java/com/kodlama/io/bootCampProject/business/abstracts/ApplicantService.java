package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.CreateApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.GetApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateApplicantRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.GetApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateApplicantResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

public interface ApplicantService {

	DataResult<List<GetAllApplicantResponse>>  getAll();
	
	DataResult<List<GetAllApplicantResponse>>  getByName(GetApplicantRequest request);
	
	DataResult<GetApplicantResponse>  getById(int id);
	
	DataResult<CreateApplicantResponse>  add(CreateApplicantRequest request);
	
	DataResult<UpdateApplicantResponse>  update(UpdateApplicantRequest request);
	
	Result delete(int id);
}
