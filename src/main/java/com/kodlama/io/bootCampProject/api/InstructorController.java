package com.kodlama.io.bootCampProject.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.bootCampProject.business.abstracts.InstructorService;
import com.kodlama.io.bootCampProject.business.requests.CreateInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateInstructorRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.GetInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateInstructorResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/instructors/")
@AllArgsConstructor
public class InstructorController {

	private final InstructorService instructorService;
	
	@GetMapping("getAll")
	public List<GetAllInstructorResponse> getAll(){
		return instructorService.getAll();
	}
	
	@GetMapping("getAllByName")
	public List<GetAllInstructorResponse> findByName(String name){
		return instructorService.findByName(name);
	}
	
	@GetMapping("getById/{id}")
	public GetInstructorResponse findById(@PathVariable int id) {
		return instructorService.findById(id);
	}
	
	@PostMapping("add")
	public CreateInstructorResponse add(CreateInstructorRequest request) {
		return instructorService.add(request);
	}
	
	@PutMapping("update")
	public UpdateInstructorResponse update(UpdateInstructorRequest request) {
		return instructorService.update(request);
	}
	
	@DeleteMapping("deleteById/{id}")
	public void delete(@PathVariable int id) {
		instructorService.delete(id);
	}
}
