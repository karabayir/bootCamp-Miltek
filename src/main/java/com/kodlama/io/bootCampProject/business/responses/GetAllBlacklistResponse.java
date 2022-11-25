package com.kodlama.io.bootCampProject.business.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBlacklistResponse {

	private int id;
	private int applicantId;
	private LocalDate date;
	private String reason;
}
