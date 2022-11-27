package com.kodlama.io.bootCampProject.business.requests.applications;

import javax.validation.constraints.NotBlank;

import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.entities.applications.ApplicationsState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateApplicationsRequest {
	
	@NotBlank(message = Messages.IdBlankException)
	private int id;
	
	@NotBlank(message = Messages.IdBlankException)
	private int userId;
	
	@NotBlank(message = Messages.IdBlankException)
	private int bootcampsId;
	
	@NotBlank(message = Messages.StateBlankException)
	private ApplicationsState state;
}
