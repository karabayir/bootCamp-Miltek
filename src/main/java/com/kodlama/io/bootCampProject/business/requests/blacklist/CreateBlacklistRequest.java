package com.kodlama.io.bootCampProject.business.requests.blacklist;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.kodlama.io.bootCampProject.business.constant.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBlacklistRequest {
	
	@NotNull(message = Messages.IdBlankException)
	private int applicantId;
	
	@NotNull(message = Messages.DateBlankException)
	private LocalDate date;
	
	@NotNull(message = Messages.StringNullException)
	private String reason;
}
