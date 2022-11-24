package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.CreateApplicationsRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateApplicationsRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.GetApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateApplicationResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

public interface ApplicationsService {

	DataResult<List<GetAllApplicationsResponse>> getAll();
	
	DataResult<GetApplicationsResponse> getById(int id);
	
	DataResult<CreateApplicationsResponse> add(CreateApplicationsRequest request);
	
	DataResult<UpdateApplicationResponse> update(UpdateApplicationsRequest request);
	
	Result delete(int id);
}
