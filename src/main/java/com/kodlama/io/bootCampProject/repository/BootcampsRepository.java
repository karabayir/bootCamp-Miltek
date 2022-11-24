package com.kodlama.io.bootCampProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.bootCampProject.entities.Bootcamps;

public interface BootcampsRepository extends JpaRepository<Bootcamps, Integer>{

	Bootcamps getBootcampsById(int id);
}
