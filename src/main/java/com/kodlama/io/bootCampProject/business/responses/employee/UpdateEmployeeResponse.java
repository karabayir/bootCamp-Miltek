package com.kodlama.io.bootCampProject.business.responses.employee;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeResponse {
	private int id;
	private String nationalIdentity;
	private Date   dateOfBirth;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String position;

}
