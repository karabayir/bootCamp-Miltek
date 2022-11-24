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

import com.kodlama.io.bootCampProject.business.abstracts.BootcampsService;
import com.kodlama.io.bootCampProject.business.requests.CreateBootcampsRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateBootcampsRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateBootcampsResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllBootcampsResponse;
import com.kodlama.io.bootCampProject.business.responses.GetBootcampsResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateBootcampsResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/bootcamps/")
@AllArgsConstructor
public class BootcampsController {

	private final BootcampsService bootcampsService;
	
	@GetMapping("getAll")
	public DataResult<List<GetAllBootcampsResponse>>  getAll(){
		return bootcampsService.getAll();
	}
	
	@GetMapping("getById/{id}")
	public DataResult<GetBootcampsResponse>  getById(@PathVariable int id){
		return bootcampsService.getById(id);
	}
	
	@PostMapping("add")
	public DataResult<CreateBootcampsResponse>  add(@RequestBody CreateBootcampsRequest request){
		return bootcampsService.add(request);
	}
	
	@PutMapping("update")
	public DataResult<UpdateBootcampsResponse> update(@RequestBody UpdateBootcampsRequest request){
		return bootcampsService.update(request);
	}
	
	@DeleteMapping("deleteById/{id}")
	Result delete(@PathVariable int id) {
		return bootcampsService.delete(id);
	}
}
