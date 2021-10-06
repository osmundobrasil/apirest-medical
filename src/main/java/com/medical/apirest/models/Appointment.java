package com.medical.apirest.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="TB_APPOINTMENT")
public class Appointment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String specialty;
	
	@Column(nullable = false)
	private Date registrationDate;
	
	@Column(nullable = false)
	private Date appointmentDate;
	
	@Column(nullable = false)
	private String appointmentTime;

	@Column(nullable = false)
	private long status;
	
	@Column(nullable = false)
	private Integer user_model_id;
	
	@Column(nullable = false)
	private long doctor_id;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public long getUser_model_id() {
		return user_model_id;
	}

	public void setUser_model_id(Integer user_model_id) {
		this.user_model_id = user_model_id;
	}

	public long getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(long doctor_id) {
		this.doctor_id = doctor_id;
	}

	
	
}
