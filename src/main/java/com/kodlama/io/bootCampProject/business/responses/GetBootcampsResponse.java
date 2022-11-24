package com.kodlama.io.bootCampProject.business.responses;

import java.time.LocalDate;

import com.kodlama.io.bootCampProject.entities.BootcampsState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBootcampsResponse {

	private int id;
	private String name;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	private BootcampsState state;
	private int instructorId;
}
