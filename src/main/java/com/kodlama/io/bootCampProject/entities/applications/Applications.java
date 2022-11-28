package com.kodlama.io.bootCampProject.entities.applications;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.kodlama.io.bootCampProject.entities.Bootcamps;
import com.kodlama.io.bootCampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Applications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="applicant_id")
	private Applicant applicant;
	
	@ManyToOne
	@JoinColumn(name = "bootcamps_id")
    private Bootcamps bootcamps;
	
	@Enumerated(EnumType.STRING)
	private ApplicationsState state;
}
