package com.kodlama.io.bootCampProject.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.bootCampProject.business.abstracts.ApplicantService;
import com.kodlama.io.bootCampProject.business.requests.applicant.CreateApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.applicant.GetApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.applicant.UpdateApplicantRequest;
import com.kodlama.io.bootCampProject.business.responses.applicant.CreateApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.applicant.GetAllApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.applicant.GetApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.applicant.UpdateApplicantResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/applicants/")
@AllArgsConstructor
public class ApplicantController {

	private final ApplicantService applicantService;
	
	@GetMapping("getAll")
	public DataResult<List<GetAllApplicantResponse>>  getAll(){
		return applicantService.getAll();
	}
	
	@GetMapping("getByName")
	public DataResult<List<GetAllApplicantResponse>> getByName(@Valid @RequestBody GetApplicantRequest request){
		return applicantService.getByName(request);
	}
	
	@GetMapping("getById/{id}")
	public DataResult<GetApplicantResponse> getById(@PathVariable int id) {
		return applicantService.getById(id);
	}
	
	@PostMapping("add")
	public DataResult<CreateApplicantResponse> add(@Valid @RequestBody CreateApplicantRequest request) {
		return applicantService.add(request);
	}
	
	@PutMapping("update")
	public DataResult<UpdateApplicantResponse> update(@Valid @RequestBody UpdateApplicantRequest request) {
		return applicantService.update(request);
	}
	
	@DeleteMapping("deleteById/{id}")
	public Result delete(@PathVariable int id) {
		return applicantService.delete(id);
	}
}
