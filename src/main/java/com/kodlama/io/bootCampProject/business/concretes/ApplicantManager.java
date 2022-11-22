package com.kodlama.io.bootCampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.ApplicantService;
import com.kodlama.io.bootCampProject.business.requests.CreateApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateApplicantRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.GetApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateApplicantResponse;
import com.kodlama.io.bootCampProject.core.utilities.mapper.ModelMapperService;
import com.kodlama.io.bootCampProject.entities.users.Applicant;
import com.kodlama.io.bootCampProject.repository.ApplicantRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

	private final ApplicantRepository applicantRepository;
	private final ModelMapperService mapperService;
	
	@Override
	public List<GetAllApplicantResponse> getAll() {
		return applicantRepository.findAll()
				.stream()
				.map(a-> mapperService.forResponse().map(a, GetAllApplicantResponse.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<GetAllApplicantResponse> getByName(String name) {
		List<Applicant> applicants = applicantRepository.findByFirstName(name);
		return applicants
				.stream()
				.map(a-> mapperService.forResponse().map(a, GetAllApplicantResponse.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public GetApplicantResponse getById(int id) {
		Applicant applicant = applicantRepository.findById(id).orElseThrow();
		return mapperService.forResponse().map(applicant, GetApplicantResponse.class);
	}
	
	@Override
	public CreateApplicantResponse add(CreateApplicantRequest request) {
		Applicant applicant = mapperService.forRequest().map(request, Applicant.class);
		applicant.setId(0);
		applicantRepository.save(applicant);
		return mapperService.forResponse().map(applicant, CreateApplicantResponse.class);
	}
	
	@Override
	public UpdateApplicantResponse update(UpdateApplicantRequest request) {
		Applicant applicant = mapperService.forRequest().map(request, Applicant.class);
		applicantRepository.save(applicant);
		return mapperService.forResponse().map(applicant, UpdateApplicantResponse.class);
	}
	@Override
	public void delete(int id) {
		applicantRepository.deleteById(id);
		
	}
}
