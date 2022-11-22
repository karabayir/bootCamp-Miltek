package com.kodlama.io.bootCampProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.bootCampProject.entities.users.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

	List<Applicant> findByFirstName(String name);
}
