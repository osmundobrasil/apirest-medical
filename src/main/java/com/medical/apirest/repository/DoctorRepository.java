package com.medical.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.apirest.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	Doctor findById(long id);

}