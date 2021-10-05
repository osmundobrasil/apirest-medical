package com.medical.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.apirest.models.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	Appointment findById(long id);

}