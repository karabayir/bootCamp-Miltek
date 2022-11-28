package com.kodlama.io.bootCampProject.business.responses.applications;

import com.kodlama.io.bootCampProject.entities.applications.ApplicationsState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetApplicationsResponse {
	private int id;
	private int applicantId;
	private int bootcampsId;
	private ApplicationsState state;
}
