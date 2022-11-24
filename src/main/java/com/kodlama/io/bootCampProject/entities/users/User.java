package com.kodlama.io.bootCampProject.entities.users;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kodlama.io.bootCampProject.entities.applications.Applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nationalIdentity;
	private String firstName;
	private String lastName;
	private Date   dateOfBirth;
	private String email;
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Applications> applications;
}
