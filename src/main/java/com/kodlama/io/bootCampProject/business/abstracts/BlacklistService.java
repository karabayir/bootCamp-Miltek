package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.blacklist.CreateBlacklistRequest;
import com.kodlama.io.bootCampProject.business.requests.blacklist.UpdateBlacklistRequest;
import com.kodlama.io.bootCampProject.business.responses.blacklist.CreateBlacklistResponse;
import com.kodlama.io.bootCampProject.business.responses.blacklist.GetAllBlacklistResponse;
import com.kodlama.io.bootCampProject.business.responses.blacklist.GetBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.blacklist.UpdateBlacklistResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.entities.Blacklist;

public interface BlacklistService {

	DataResult<List<GetAllBlacklistResponse>> getAll();
	
	DataResult<GetBlackListResponse> getById(int id);
	
	DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest request);
	
	DataResult<UpdateBlacklistResponse> update (UpdateBlacklistRequest request);
	
	Result delete(int id);
	
	Blacklist getBlacklistById(int id);
	
	 boolean existsBlacklistByApplicantId(int userId);
	
}
