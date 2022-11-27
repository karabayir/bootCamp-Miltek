package com.kodlama.io.bootCampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.ApplicationsService;
import com.kodlama.io.bootCampProject.business.abstracts.BlacklistService;
import com.kodlama.io.bootCampProject.business.abstracts.BootcampsService;
import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.business.requests.applications.CreateApplicationsRequest;
import com.kodlama.io.bootCampProject.business.requests.applications.UpdateApplicationsRequest;
import com.kodlama.io.bootCampProject.business.responses.applications.CreateApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.applications.GetAllApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.applications.GetApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.applications.UpdateApplicationResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlama.io.bootCampProject.entities.Bootcamps;
import com.kodlama.io.bootCampProject.entities.BootcampsState;
import com.kodlama.io.bootCampProject.entities.applications.Applications;
import com.kodlama.io.bootCampProject.repository.ApplicationsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationsManager implements ApplicationsService {

	private final ApplicationsRepository applicationsRepository;
	private final ModelMapperService mapperService;
	private final BlacklistService blacklistService;
	private final BootcampsService bootcampsService;

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
		checkIfApplicationsExistById(id);
		Applications applications = applicationsRepository.getApplicationById(id);
		GetApplicationsResponse response = mapperService.forResponse().map(applications, GetApplicationsResponse.class);
		return new SuccessDataResult<GetApplicationsResponse>(response, "getById Applications");
	}
	@Override
	public DataResult<CreateApplicationsResponse> add(CreateApplicationsRequest request) {
		checkIfUserBlacklist(request.getUserId());
		checkIfUserHasApplication(request.getUserId());
		checkIfBootcampIsActive(request.getBootcampsId());
		Applications applications = mapperService.forRequest().map(request, Applications.class);
		applications.setId(0);
		applicationsRepository.save(applications);
		CreateApplicationsResponse response = mapperService.forResponse().map(applications, CreateApplicationsResponse.class);
		return new SuccessDataResult<CreateApplicationsResponse>(response, Messages.ApplicationCreated);
	}
	@Override
	public DataResult<UpdateApplicationResponse> update(UpdateApplicationsRequest request) {
		checkIfApplicationsExistById(request.getId());
		Applications applications = mapperService.forRequest().map(request, Applications.class);
		applicationsRepository.save(applications);
		UpdateApplicationResponse response = mapperService.forResponse().map(applications, UpdateApplicationResponse.class);
		return new SuccessDataResult<UpdateApplicationResponse>(response, Messages.ApplicationUpdated);
	}
	@Override
	public Result delete(int id) {
		checkIfApplicationsExistById(id);
		applicationsRepository.deleteById(id);
		return new SuccessResult(Messages.ApplicationsDeleted);
	}
	
	private void checkIfApplicationsExistById(int id) {
		if(applicationsRepository.getApplicationById(id) == null)
			throw new BusinessException(id+Messages.ApplicationIdException);
	}
	
	private void  checkIfUserHasApplication(int id) {
		if(applicationsRepository.existsApplicationsByUserId(id))
			throw new BusinessException(id+Messages.UserHasApplication);
	}
	
	private void  checkIfUserBlacklist(int id) {
		if(blacklistService.existsBlacklistByApplicantId(id))
			throw new BusinessException(id+" numaralı kullanıcı karalistede");
	}

	private void checkIfBootcampIsActive(int bootcampsId) {
		Bootcamps bootcamps = bootcampsService.getBootcampsById(bootcampsId);
		if(bootcamps.getState()== BootcampsState.CLOSED)
			throw new BusinessException(Messages.BootcampActiveException);
	}
}
