package com.kodlama.io.bootCampProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.bootCampProject.entities.Blacklist;

public interface BlacklistRepository extends JpaRepository<Blacklist, Integer> {

	Blacklist getBlacklistById(int id);
	
	 boolean existsBlacklistByApplicantId(int userId);
}
