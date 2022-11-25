package com.kodlama.io.bootCampProject.business.requests;

import java.time.LocalDate;


import javax.validation.constraints.NotNull;

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
	private String name;
	
	@NotNull(message = Messages.DateBlankException)
	private LocalDate dateStart;
	
	@NotNull(message = Messages.DateBlankException)
	private LocalDate dateEnd;
	
	@NotNull(message = Messages.StateBlankException)
	private BootcampsState state;
	
	@NotNull(message = Messages.IdBlankException)
	private int instructorId;
}
