package com.kodlama.io.bootCampProject.business.requests.applications;


import javax.validation.constraints.NotNull;

import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.entities.applications.ApplicationsState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicationsRequest {

	@NotNull(message = Messages.IdBlankException)
	private int userId;
	
	@NotNull(message = Messages.IdBlankException)
	private int bootcampsId;
	
	@NotNull(message = Messages.StateBlankException)
	private ApplicationsState state;
}
