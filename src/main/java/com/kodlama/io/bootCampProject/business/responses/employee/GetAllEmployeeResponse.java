package com.kodlama.io.bootCampProject.business.responses.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllEmployeeResponse {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String position;
}
