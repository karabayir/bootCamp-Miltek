package com.kodlama.io.bootCampProject.business.requests;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.kodlama.io.bootCampProject.business.constant.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateInstructorRequest {
	

	@Size(min = 11 , max = 11 , message = Messages.NationalIdentityNumberSizeException)
	@NotNull(message = Messages.NationalIdentityBlankException)
	private String nationalIdentity;
	
	@NotNull(message =Messages.DateBlankException)
	private Date   dateOfBirth;
	
	@NotNull(message =Messages.NameBlankException)
	private String firstName;
	
	@NotNull(message =Messages.NameBlankException)
	private String lastName;
	
	@NotNull(message =Messages.MailBlankException)
	@Email
	private String email;
	
	@NotNull(message =Messages.PasswordBlankException)
	private String password;
	
	@NotNull(message =Messages.NameBlankException)
	private String companyName;
}
