package com.kodlama.io.bootCampProject.business.requests.applicant;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.kodlama.io.bootCampProject.business.constant.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateApplicantRequest {

	@NotNull(message = Messages.IdBlankException)
	@Min(value = 1 , message = Messages.IdMınimumException)
	private int id;

	@Size(min = 11 , max = 11 , message = Messages.NationalIdentityNumberSizeException)
	@NotNull(message = Messages.NationalIdentityBlankException)
	private String nationalIdentity;
	
	@NotNull(message = Messages.DateBlankException)
	private LocalDate   dateOfBirth;
	
	@NotNull(message = Messages.NameBlankException)
	@Length(min = 3 , message = Messages.NameLengthException)
	private String firstName;
	
	@NotNull(message = Messages.NameBlankException)
	@Length(min = 3 , message = Messages.NameLengthException)
	private String lastName;
	
	@NotNull(message = Messages.MailBlankException)
	@Email
	private String email;
	
	@NotNull(message = Messages.PasswordBlankException)
	private String password;

	@NotNull(message = Messages.StringNullException)
	private String about;
}
