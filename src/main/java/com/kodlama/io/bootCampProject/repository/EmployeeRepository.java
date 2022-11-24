package com.kodlama.io.bootCampProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.bootCampProject.entities.users.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByFirstName(String name);
	
	Employee findByNationalIdentity(String identity);
	
	Employee getEmployeeById(int id);
}
