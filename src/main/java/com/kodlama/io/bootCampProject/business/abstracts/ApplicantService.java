package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.CreateApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateApplicantRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.GetApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateApplicantResponse;

public interface ApplicantService {

	List<GetAllApplicantResponse> getAll();
	
	List<GetAllApplicantResponse> getByName(String name);
	
	GetApplicantResponse getById(int id);
	
	CreateApplicantResponse add(CreateApplicantRequest request);
	
	UpdateApplicantResponse update(UpdateApplicantRequest request);
	
	void delete(int id);
}
