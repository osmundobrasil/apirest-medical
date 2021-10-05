package com.medical.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.apirest.models.Appointment;
import com.medical.apirest.repository.AppointmentRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Medical")
public class AppointmentResource {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@ApiOperation(value="Get list appointments")
	@GetMapping("/appointments")
	public List<Appointment> ListAppointments(){
		return appointmentRepository.findAll();
	}
	
	@ApiOperation(value="Get single appointment")
	@GetMapping("/appointment/{id}")
	public Appointment SingleAppointmentList(@PathVariable(value="id") long id){
		return appointmentRepository.findById(id);
	}
	
	@ApiOperation(value="Save appointment")
	@PostMapping("/appointment")
	public Appointment saveAppointment(@RequestBody Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	
	@ApiOperation(value="Delete appointment")
	@DeleteMapping("/appointment")
	public void deleteAppointment(@RequestBody Appointment appointment) {
		appointmentRepository.delete(appointment);
	}
	
	@ApiOperation(value="Update appointment")
	@PutMapping("/appointment")
	public Appointment updadeAppointment(@RequestBody Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

}
