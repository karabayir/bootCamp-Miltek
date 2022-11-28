package com.kodlama.io.bootCampProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.bootCampProject.entities.applications.Applications;

public interface  ApplicationsRepository  extends JpaRepository<Applications, Integer>{

	Applications getApplicationById(int id);
	
	 boolean existsApplicationsByApplicantId(int applicantId);
	 
}
