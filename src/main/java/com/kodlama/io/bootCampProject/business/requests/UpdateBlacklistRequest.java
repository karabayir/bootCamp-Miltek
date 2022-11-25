package com.kodlama.io.bootCampProject.business.requests;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.kodlama.io.bootCampProject.business.constant.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBlacklistRequest {

	@NotNull(message = Messages.IdBlankException)
	private int id;
	
	@NotNull(message = Messages.IdBlankException)
	private int applicantId;
	
	@NotNull(message = Messages.DateBlankException)
	private LocalDate date;
	
	private String reason;
}
