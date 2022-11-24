package com.kodlama.io.bootCampProject.entities.users;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kodlama.io.bootCampProject.entities.Bootcamps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "instructors")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Instructor extends User{
	private String companyName;
	
	@OneToMany(mappedBy = "instructor")
	private List<Bootcamps> bootcamps;
}
