package com.kodlama.io.bootCampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.BootcampsService;
import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.business.requests.CreateBootcampsRequest;
import com.kodlama.io.bootCampProject.business.requests.UpdateBootcampsRequest;
import com.kodlama.io.bootCampProject.business.responses.CreateBootcampsResponse;
import com.kodlama.io.bootCampProject.business.responses.GetAllBootcampsResponse;
import com.kodlama.io.bootCampProject.business.responses.GetBootcampsResponse;
import com.kodlama.io.bootCampProject.business.responses.UpdateBootcampsResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlama.io.bootCampProject.entities.Bootcamps;
import com.kodlama.io.bootCampProject.entities.BootcampsState;
import com.kodlama.io.bootCampProject.repository.BootcampsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BootcampsManager implements BootcampsService {

	private final BootcampsRepository bootcampsRepository;
	private final ModelMapperService mapperService;
	
	@Override
	public DataResult<List<GetAllBootcampsResponse>> getAll() {
		List<GetAllBootcampsResponse> response = bootcampsRepository.findAll()
				.stream()
				.map(b-> mapperService.forResponse().map(b, GetAllBootcampsResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBootcampsResponse>>(response, "getAll Bootcamps");
	}
	@Override
	public DataResult<GetBootcampsResponse> getById(int id) {
		checkIfBootcampsExistById(id);
		Bootcamps bootcamps = bootcampsRepository.getBootcampsById(id);
		GetBootcampsResponse response = mapperService.forResponse().map(bootcamps, GetBootcampsResponse.class);
		return new SuccessDataResult<GetBootcampsResponse>(response, "getById Bootcamps");
	}
	@Override
	public DataResult<CreateBootcampsResponse> add(CreateBootcampsRequest request) {
		Bootcamps bootcamps = mapperService.forRequest().map(request, Bootcamps.class);
		bootcamps.setId(0);
		bootcampsRepository.save(bootcamps);
		CreateBootcampsResponse response = mapperService.forResponse().map(bootcamps, CreateBootcampsResponse.class);
		return new SuccessDataResult<CreateBootcampsResponse>(response, Messages.BootcampsCreated);
	}
	@Override
	public DataResult<UpdateBootcampsResponse> update(UpdateBootcampsRequest request) {
		checkIfBootcampsExistById(request.getId());
		Bootcamps bootcamps = mapperService.forRequest().map(request, Bootcamps.class);
		bootcampsRepository.save(bootcamps);
		UpdateBootcampsResponse response = mapperService.forResponse().map(bootcamps, UpdateBootcampsResponse.class);
		return new SuccessDataResult<UpdateBootcampsResponse>(response, Messages.BootcampsUpdated);
	}
	@Override
	public Result delete(int id) {
		checkIfBootcampsExistById(id);
		bootcampsRepository.deleteById(id);
		return new SuccessResult(Messages.BootcampsDeleted);
	}
	
	private void checkIfBootcampsExistById(int id) {
		if(bootcampsRepository.getBootcampsById(id) == null)
			throw new BusinessException(id+Messages.BootcampsIdException);
	}
	
	@Override
	public void checkIfBootcampIsActive(int id) {
		Bootcamps bootcamps = bootcampsRepository.findById(id).orElseThrow();
		if(bootcamps.getState()== BootcampsState.CLOSED)
			throw new BusinessException(Messages.BootcampActiveException);
	}
	
}
