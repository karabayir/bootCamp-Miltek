package com.kodlama.io.bootCampProject.business.responses.blacklist;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBlacklistResponse {

	private int id;
	private int applicantId;
	private LocalDate date;
	private String reason;
}
