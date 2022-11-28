package com.kodlama.io.bootCampProject.business.requests.applications;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.entities.applications.ApplicationsState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateApplicationsRequest {
	
	@NotNull(message = Messages.IdBlankException)
	@Min(value = 1 , message = Messages.IdMınimumException)
	private int id;
	
	@NotNull(message = Messages.IdBlankException)
	@Min(value = 1 , message = Messages.IdMınimumException)
	private int applicantId;
	
	@NotNull(message = Messages.IdBlankException)
	@Min(value = 1 , message = Messages.IdMınimumException)
	private int bootcampsId;
	
	@NotNull(message = Messages.StateBlankException)
	private ApplicationsState state;
}
