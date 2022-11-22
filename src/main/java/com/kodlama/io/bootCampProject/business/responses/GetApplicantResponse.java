package com.kodlama.io.bootCampProject.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetApplicantResponse {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String about;
}
