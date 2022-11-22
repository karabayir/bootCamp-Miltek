package com.kodlama.io.bootCampProject.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicantRequest {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String about;
}
