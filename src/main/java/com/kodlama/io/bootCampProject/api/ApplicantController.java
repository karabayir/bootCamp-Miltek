package com.kodlama.io.bootCampProject.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.bootCampProject.business.abstracts.ApplicantService;
import com.kodlama.io.bootCampProject.business.requests.CreateApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateApplicantRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.GetApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateApplicantResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/applicants/")
@AllArgsConstructor
public class ApplicantController {

	private final ApplicantService applicantService;
	
	@GetMapping("getAll")
	public List<GetAllApplicantResponse> getAll(){
		return applicantService.getAll();
	}
	
	@GetMapping("getByName")
	public List<GetAllApplicantResponse> getByName(String name){
		return applicantService.getByName(name);
	}
	
	@GetMapping("getById/{id}")
	public GetApplicantResponse getById(@PathVariable int id) {
		return applicantService.getById(id);
	}
	
	@PostMapping("add")
	public CreateApplicantResponse add(CreateApplicantRequest request) {
		return applicantService.add(request);
	}
	
	@PutMapping("update")
	public UpdateApplicantResponse update(UpdateApplicantRequest request) {
		return applicantService.update(request);
	}
	
	@DeleteMapping("deleteById/{id}")
	public void delete(@PathVariable int id) {
		applicantService.delete(id);
	}
}
