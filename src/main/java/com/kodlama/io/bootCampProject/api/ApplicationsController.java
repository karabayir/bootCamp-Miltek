package com.kodlama.io.bootCampProject.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.bootCampProject.business.abstracts.ApplicationsService;
import com.kodlama.io.bootCampProject.business.requests.CreateApplicationsRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateApplicationsRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.GetApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateApplicationResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/applications")
@AllArgsConstructor
public class ApplicationsController {

	private final ApplicationsService applicationsService;
	
	@GetMapping("getAll")
	public DataResult<List<GetAllApplicationsResponse>>  getAll(){
		return applicationsService.getAll();
	}
	
	@GetMapping("getById/{id}")
	public DataResult<GetApplicationsResponse> getById(@PathVariable int id){
		return applicationsService.getById(id);
	}
	
	@PostMapping("add")
	public DataResult<CreateApplicationsResponse> add(@RequestBody CreateApplicationsRequest request){
		return applicationsService.add(request);
	}
	
	@PutMapping("update")
	public DataResult<UpdateApplicationResponse> update(@RequestBody UpdateApplicationsRequest request){
		return applicationsService.update(request);
	}
	
	@DeleteMapping("deleteById/{id}")
	Result delete(@PathVariable int id) {
		return applicationsService.delete(id);
	}
}
