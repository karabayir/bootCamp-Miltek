package com.kodlama.io.bootCampProject.business.requests.applicant;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.kodlama.io.bootCampProject.business.constant.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetApplicantRequest {

	@NotNull(message =Messages.NameBlankException)
	@Length(min = 3 , message = Messages.NameLengthException)
	private String firstName;
}
