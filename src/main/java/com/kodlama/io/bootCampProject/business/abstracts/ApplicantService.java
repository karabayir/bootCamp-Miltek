package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.applicant.CreateApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.applicant.GetApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.applicant.UpdateApplicantRequest;
import com.kodlama.io.bootCampProject.business.responses.applicant.CreateApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.applicant.GetAllApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.applicant.GetApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.applicant.UpdateApplicantResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

public interface ApplicantService {

	DataResult<List<GetAllApplicantResponse>>  getAll();
	
	DataResult<List<GetAllApplicantResponse>>  getByName(GetApplicantRequest request);
	
	DataResult<GetApplicantResponse>  getById(int id);
	
	DataResult<CreateApplicantResponse>  add(CreateApplicantRequest request);
	
	DataResult<UpdateApplicantResponse>  update(UpdateApplicantRequest request);
	
	Result delete(int id);
	
	void checkIfApplicantExistById(int id);
}
