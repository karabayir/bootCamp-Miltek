package com.kodlama.io.bootCampProject.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.kodlama.io.bootCampProject.entities.applications.Applications;
import com.kodlama.io.bootCampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bootcamps {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	
	private LocalDate dateStart;
	private LocalDate dateEnd;
	
	@Enumerated(EnumType.STRING)
	private BootcampsState state;
	
	@OneToMany(mappedBy = "bootcamps")
	private List<Applications> applications;

}
