package com.kodlama.io.bootCampProject.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.BootcampsService;
import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.business.requests.bootcamps.CreateBootcampsRequest;
import com.kodlama.io.bootCampProject.business.requests.bootcamps.UpdateBootcampsRequest;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.CreateBootcampsResponse;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.GetAllBootcampsResponse;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.GetBootcampsResponse;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.UpdateBootcampsResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlama.io.bootCampProject.entities.Bootcamps;
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
		//checkIfBootcampsDateAdd(request);
		checkIfDateException(request.getDateStart(), request.getDateEnd());
		Bootcamps bootcamps = mapperService.forRequest().map(request, Bootcamps.class);
		bootcamps.setId(0);
		bootcampsRepository.save(bootcamps);
		CreateBootcampsResponse response = mapperService.forResponse().map(bootcamps, CreateBootcampsResponse.class);
		return new SuccessDataResult<CreateBootcampsResponse>(response, Messages.BootcampsCreated);
	}
	@Override
	public DataResult<UpdateBootcampsResponse> update(UpdateBootcampsRequest request) {
		//checkIfBootcampsDateUpdate(request);
		checkIfBootcampsExistById(request.getId());
		checkIfDateException(request.getDateStart(), request.getDateEnd());
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
	
	@Override
	public Bootcamps getBootcampsById(int id) {
		return bootcampsRepository.findById(id).orElseThrow();
	}
	
	private void checkIfBootcampsExistById(int id) {
		if(bootcampsRepository.getBootcampsById(id) == null)
			throw new BusinessException(id+Messages.BootcampsIdException);
	}
	
	/*private void checkIfBootcampsDateAdd(CreateBootcampsRequest request) {
		if(request.getDateEnd().isBefore(request.getDateStart()))
			throw new BusinessException("tarih hatası");
	}
	
	private void checkIfBootcampsDateUpdate(UpdateBootcampsRequest request) {
		if(request.getDateEnd().isBefore(request.getDateStart()))
			throw new BusinessException("tarih hatası");
	}*/
	
	//designed by @torukobyte
	
	private void checkIfDateException(@NotNull LocalDate startDate, LocalDate endDate) { 
		if(endDate.isBefore(startDate))
			throw new BusinessException(Messages.BootcampsDateException);
	}
	
	
	
}
