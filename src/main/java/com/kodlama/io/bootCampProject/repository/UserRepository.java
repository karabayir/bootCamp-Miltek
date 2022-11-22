package com.kodlama.io.bootCampProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.bootCampProject.entities.users.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
}
