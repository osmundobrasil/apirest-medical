package com.medical.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medical.apirest.models.Appointment;

public interface AppointmentByUserId extends JpaRepository<Appointment, Integer> {
	
	@Query("SELECT a FROM Appointment a WHERE a.user_model_id = ?1")
	List<Object> getAppByIdUser(Integer IdUser);
	

}
