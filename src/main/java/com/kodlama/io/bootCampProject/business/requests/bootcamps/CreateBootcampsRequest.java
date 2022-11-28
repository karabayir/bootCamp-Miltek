package com.kodlama.io.bootCampProject.business.requests.bootcamps;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.entities.BootcampsState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBootcampsRequest {

	@NotNull(message = Messages.NameBlankException)
	@Length(min = 3 , message = Messages.NameLengthException)
	private String name;
	
	@NotNull(message = Messages.DateBlankException)
	private LocalDate dateStart;
	
	@NotNull(message = Messages.DateBlankException)
	private LocalDate dateEnd;
	
	@NotNull(message = Messages.StateBlankException)
	private BootcampsState state;
	
	@NotNull(message = Messages.IdBlankException)
	@Min(value = 1 , message = Messages.IdMınimumException)
	private int instructorId;
}
