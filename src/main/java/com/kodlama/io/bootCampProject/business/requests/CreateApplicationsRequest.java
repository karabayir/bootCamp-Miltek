package com.kodlama.io.bootCampProject.business.requests;

import com.kodlama.io.bootCampProject.entities.applications.ApplicationsState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicationsRequest {

	private int userId;
	private int bootcampsId;
	private ApplicationsState state;
}
