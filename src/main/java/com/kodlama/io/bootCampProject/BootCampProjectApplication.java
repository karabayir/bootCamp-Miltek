package com.kodlama.io.bootCampProject;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlama.io.bootCampProject.core.utilities.results.ErrorDataResult;

@SpringBootApplication
@RestControllerAdvice
public class BootCampProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootCampProjectApplication.class, args);
	}

	@Bean
	ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationsException(MethodArgumentNotValidException exception){
		Map<String, String> validationErrors= new HashMap<>();
		for(FieldError fieldError: exception.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		 ErrorDataResult<Object> result = new ErrorDataResult<Object>(validationErrors,"VALIDATION EXCEPTION");
		return result;
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleBusinessException(BusinessException businessException){
		ErrorDataResult<Object> errorDataResult= new ErrorDataResult<Object>(businessException.getMessage(),"BUSINESS EXCEPTİON");
		return errorDataResult;
	}
}
