package com.kodlama.io.bootCampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.ApplicantService;
import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.business.requests.applicant.CreateApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.applicant.GetApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.applicant.UpdateApplicantRequest;
import com.kodlama.io.bootCampProject.business.responses.applicant.CreateApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.applicant.GetAllApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.applicant.GetApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.applicant.UpdateApplicantResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlama.io.bootCampProject.entities.users.Applicant;
import com.kodlama.io.bootCampProject.repository.ApplicantRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

	private final ApplicantRepository applicantRepository;
	private final ModelMapperService mapperService;
	
	@Override
	public DataResult<List<GetAllApplicantResponse>>  getAll() {
		List<GetAllApplicantResponse> result= applicantRepository.findAll()
				.stream()
				.map(a-> mapperService.forResponse().map(a, GetAllApplicantResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicantResponse>>(result, "getAll");
	}
	
	@Override
	public DataResult<List<GetAllApplicantResponse>>  getByName(GetApplicantRequest request) {
		List<Applicant> applicants = applicantRepository.findByFirstName(request.getFirstName());
		List<GetAllApplicantResponse> response = applicants
				.stream()
				.map(a-> mapperService.forResponse().map(a, GetAllApplicantResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicantResponse>>(response, "getAllByName");
	}
	
	@Override
	public DataResult<GetApplicantResponse>  getById(int id) {
		checkIfApplicantExistById(id);
		Applicant applicant = applicantRepository.findById(id).orElseThrow(/*() -> new BusinessException(id+Messages.ApplicantIdException)*/);
		GetApplicantResponse response= mapperService.forResponse().map(applicant, GetApplicantResponse.class);
		return new SuccessDataResult<GetApplicantResponse>(response, "getById");
	}
	
	@Override
	public DataResult<CreateApplicantResponse>  add(CreateApplicantRequest request) {
		Applicant applicant = mapperService.forRequest().map(request, Applicant.class);
		checkIfApplicantExistByNationalIdentity(request.getNationalIdentity());
		applicantRepository.save(applicant);
		CreateApplicantResponse response = mapperService.forResponse().map(applicant, CreateApplicantResponse.class);
		return new SuccessDataResult<CreateApplicantResponse>(response, Messages.ApplicantCreated);
	}
	
	@Override
	public DataResult<UpdateApplicantResponse>  update(UpdateApplicantRequest request) {
		checkIfApplicantExistById(request.getId());
		Applicant applicant = mapperService.forRequest().map(request, Applicant.class);
		checkIfApplicantExistByNationalIdentity(request.getNationalIdentity());
		applicantRepository.save(applicant);
		UpdateApplicantResponse response =  mapperService.forResponse().map(applicant, UpdateApplicantResponse.class);
		return new SuccessDataResult<UpdateApplicantResponse>(response, Messages.ApplicantUpdated);
	}
	@Override
	public Result delete(int id) {
		checkIfApplicantExistById(id);
		applicantRepository.deleteById(id);
		return new SuccessResult(Messages.ApplicantDeleted);
	}
	//rules
	private void checkIfApplicantExistByNationalIdentity(String identity) {
		
		if(applicantRepository.findByNationalIdentity(identity) != null)
			throw new BusinessException(identity+ Messages.ApplicantNationalIdentityException);
	}
	
	@Override
	public void checkIfApplicantExistById(int id){
		if(applicantRepository.getApplicantById(id) == null)
			throw new BusinessException(id+Messages.ApplicantIdException);
	}
}
