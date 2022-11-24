package com.kodlama.io.bootCampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.ApplicationsService;
import com.kodlama.io.bootCampProject.business.requests.CreateApplicationsRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateApplicationsRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.GetApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateApplicationResponse;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlama.io.bootCampProject.entities.applications.Applications;
import com.kodlama.io.bootCampProject.repository.ApplicationsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationsManager implements ApplicationsService {

	private final ApplicationsRepository applicationsRepository;
	private final ModelMapperService mapperService;
	@Override
	public DataResult<List<GetAllApplicationsResponse>> getAll() {
		List<GetAllApplicationsResponse> response = applicationsRepository.findAll()
				.stream()
				.map(a-> mapperService.forResponse().map(a, GetAllApplicationsResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicationsResponse>>(response, "getAll Applications");
	}
	@Override
	public DataResult<GetApplicationsResponse> getById(int id) {
		Applications applications = applicationsRepository.findById(id).orElseThrow();
		GetApplicationsResponse response = mapperService.forResponse().map(applications, GetApplicationsResponse.class);
		return new SuccessDataResult<GetApplicationsResponse>(response, "getById Applications");
	}
	@Override
	public DataResult<CreateApplicationsResponse> add(CreateApplicationsRequest request) {
		Applications applications = mapperService.forRequest().map(request, Applications.class);
		applicationsRepository.save(applications);
		CreateApplicationsResponse response = mapperService.forResponse().map(applications, CreateApplicationsResponse.class);
		return new SuccessDataResult<CreateApplicationsResponse>(response, "Applications add");
	}
	@Override
	public DataResult<UpdateApplicationResponse> update(UpdateApplicationsRequest request) {
		Applications applications = mapperService.forRequest().map(request, Applications.class);
		applicationsRepository.save(applications);
		UpdateApplicationResponse response = mapperService.forResponse().map(applications, UpdateApplicationResponse.class);
		return new SuccessDataResult<UpdateApplicationResponse>(response, "Applications update");
	}
	@Override
	public Result delete(int id) {
		applicationsRepository.deleteById(id);
		return new SuccessResult("Aplication deleted");
	}
	
	
}
