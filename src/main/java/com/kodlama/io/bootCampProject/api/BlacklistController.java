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

import com.kodlama.io.bootCampProject.business.abstracts.BlacklistService;
import com.kodlama.io.bootCampProject.business.requests.CreateBlacklistRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateBlacklistRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateBlacklistResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllBlacklistResponse;
import com.kodlama.io.bootCampProject.business.responses.GetBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateBlacklistResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/blacklists/")
@AllArgsConstructor
public class BlacklistController {

	private final BlacklistService blacklistService;
	
	@GetMapping("getAll")
	public DataResult<List<GetAllBlacklistResponse>> getAll(){
		return blacklistService.getAll();
	}
	
	@GetMapping("getById/{id}")
	public DataResult<GetBlackListResponse> getById(@PathVariable int id){ 
		return blacklistService.getById(id);
	}
	
	@PostMapping("add")
	public DataResult<CreateBlacklistResponse> add(@Valid @RequestBody CreateBlacklistRequest request){
		return blacklistService.add(request);
	}
	
	@PutMapping("update")
	DataResult<UpdateBlacklistResponse> update (@Valid @RequestBody UpdateBlacklistRequest request){
		return blacklistService.update(request);
	}
	
	@DeleteMapping("deleteById/{id}")
	Result delete(@PathVariable int id) {
		return blacklistService.delete(id);
	}
}
