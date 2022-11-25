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

import com.kodlama.io.bootCampProject.business.abstracts.InstructorService;
import com.kodlama.io.bootCampProject.business.requests.CreateInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.GetInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateInstructorRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.GetInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateInstructorResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/instructors/")
@AllArgsConstructor
public class InstructorsController {

	private final InstructorService instructorService;
	
	@GetMapping("getAll")
	public DataResult<List<GetAllInstructorResponse>>  getAll(){
		return instructorService.getAll();
	}
	
	@GetMapping("getAllByName")
	public DataResult<List<GetAllInstructorResponse>>  findByName(@Valid @RequestBody GetInstructorRequest request){
		return instructorService.findByName(request);
	}
	
	@GetMapping("getById/{id}")
	public DataResult<GetInstructorResponse>  findById(@Valid @PathVariable int id) {
		return instructorService.findById(id);
	}
	
	@PostMapping("add")
	public DataResult<CreateInstructorResponse>  add(@Valid @RequestBody CreateInstructorRequest request) {
		return instructorService.add(request);
	}
	
	@PutMapping("update")
	public DataResult<UpdateInstructorResponse>  update(@Valid @RequestBody UpdateInstructorRequest request) {
		return instructorService.update(request);
	}
	
	@DeleteMapping("deleteById/{id}")
	public Result delete(@PathVariable int id) {
		return instructorService.delete(id);
	}
}
