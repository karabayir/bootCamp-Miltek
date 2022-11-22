package com.kodlama.io.bootCampProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.bootCampProject.entities.users.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

	List<Instructor> findByFirstName(String name);
}
