package com.kodlama.io.bootCampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.BlacklistService;
import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.business.requests.blacklist.CreateBlacklistRequest;
import com.kodlama.io.bootCampProject.business.requests.blacklist.UpdateBlacklistRequest;
import com.kodlama.io.bootCampProject.business.responses.blacklist.CreateBlacklistResponse;
import com.kodlama.io.bootCampProject.business.responses.blacklist.GetAllBlacklistResponse;
import com.kodlama.io.bootCampProject.business.responses.blacklist.GetBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.blacklist.UpdateBlacklistResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlama.io.bootCampProject.entities.Blacklist;
import com.kodlama.io.bootCampProject.repository.BlacklistRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BlacklistManager implements BlacklistService {
	
	private final BlacklistRepository blacklistRepository;
	private final ModelMapperService mapperService;
	

	@Override
	public DataResult<List<GetAllBlacklistResponse>> getAll() {
		List<GetAllBlacklistResponse> response = blacklistRepository.findAll()
				.stream()
				.map(b-> mapperService.forResponse().map(b, GetAllBlacklistResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBlacklistResponse>>(response, "blacklist getAll");
	}

	@Override
	public DataResult<GetBlackListResponse> getById(int id) {
		checkIfBlacklistExistById(id);
		Blacklist blacklist = blacklistRepository.getBlacklistById(id);
		GetBlackListResponse  response = mapperService.forResponse().map(blacklist, GetBlackListResponse.class);
		return new SuccessDataResult<GetBlackListResponse>(response, "getById");
	}

	@Override
	public DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest request) {
		Blacklist blacklist = mapperService.forRequest().map(request, Blacklist.class);
		blacklist.setId(0);
		blacklistRepository.save(blacklist);
		CreateBlacklistResponse response = mapperService.forResponse().map(blacklist, CreateBlacklistResponse.class);
		return new SuccessDataResult<CreateBlacklistResponse>(response, Messages.BlacklistCreated);
	}

	@Override
	public DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest request) {
		checkIfBlacklistExistById(request.getId());
		Blacklist blacklist = mapperService.forRequest().map(request, Blacklist.class);
		blacklistRepository.save(blacklist);
		UpdateBlacklistResponse response = mapperService.forResponse().map(blacklist, UpdateBlacklistResponse.class);
		return new SuccessDataResult<UpdateBlacklistResponse>(response, Messages.BlacklistUpdated);
	}
	
	@Override
	public Blacklist getBlacklistById(int id) {
		return blacklistRepository.getBlacklistById(id);
	}

	@Override
	public Result delete(int id) {
		checkIfBlacklistExistById(id);
		blacklistRepository.deleteById(id);
		return new SuccessResult(Messages.BlacklistDeleted);
	}

	@Override
	 public boolean existsBlacklistByApplicantId(int userId) {
		 return blacklistRepository.existsBlacklistByApplicantId(userId);
	 }
	
	private void checkIfBlacklistExistById(int id) {
		if(blacklistRepository.getBlacklistById(id) == null)
			throw new BusinessException(id+Messages.BlacklistIdException);
	}
}
