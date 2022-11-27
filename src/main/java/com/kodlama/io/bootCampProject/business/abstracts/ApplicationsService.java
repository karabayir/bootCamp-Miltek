package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.applications.CreateApplicationsRequest;
import com.kodlama.io.bootCampProject.business.requests.applications.UpdateApplicationsRequest;
import com.kodlama.io.bootCampProject.business.responses.applications.CreateApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.applications.GetAllApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.applications.GetApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.applications.UpdateApplicationResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
public interface ApplicationsService {

	DataResult<List<GetAllApplicationsResponse>> getAll();
	
	DataResult<GetApplicationsResponse> getById(int id);
	
	DataResult<CreateApplicationsResponse> add(CreateApplicationsRequest request);
	
	DataResult<UpdateApplicationResponse> update(UpdateApplicationsRequest request);
	
	Result delete(int id);
	
	//void deleteApplicationsByUserId(int userId);
}
