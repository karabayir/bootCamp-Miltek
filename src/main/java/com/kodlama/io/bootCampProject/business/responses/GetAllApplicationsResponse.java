package com.kodlama.io.bootCampProject.business.responses;
import com.kodlama.io.bootCampProject.entities.applications.ApplicationsState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllApplicationsResponse {

	private int id;
	private int userId;
	private int bootcampsId;
	private ApplicationsState state;
}