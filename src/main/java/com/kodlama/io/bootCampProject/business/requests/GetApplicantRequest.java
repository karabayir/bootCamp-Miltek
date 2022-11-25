package com.kodlama.io.bootCampProject.business.requests;

import javax.validation.constraints.NotNull;

import com.kodlama.io.bootCampProject.business.constant.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetApplicantRequest {

	@NotNull(message =Messages.NameBlankException)
	private String firstName;
}
