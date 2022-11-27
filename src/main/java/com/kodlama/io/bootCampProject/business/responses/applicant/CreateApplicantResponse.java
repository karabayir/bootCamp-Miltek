package com.kodlama.io.bootCampProject.business.responses.applicant;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicantResponse {

	private int id;
	private String nationalIdentity;
	private LocalDate   dateOfBirth;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String about;
}
