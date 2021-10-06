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

import com.medical.apirest.models.Doctor;
import com.medical.apirest.repository.DoctorRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Medical")
public class DoctorResource {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@ApiOperation(value="Get list doctors")
	@GetMapping("/doctors")
	public List<Doctor> ListDoctors(){
		return doctorRepository.findAll();
	}
	
	@ApiOperation(value="Get single doctor")
	@GetMapping("/doctor/{id}")
	public Doctor SingleDoctorList(@PathVariable(value="id") long id){
		return doctorRepository.findById(id);
	}
	
	@ApiOperation(value="Salve doctor")
	@PostMapping("/doctor")
	public Doctor saveDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	@ApiOperation(value="Delete doctor")
	@DeleteMapping("/doctor")
	public void deleteDoctor(@RequestBody Doctor doctor) {
		doctorRepository.delete(doctor);
	}
	
	@ApiOperation(value="Update doctor")
	@PutMapping("/doctor")
	public Doctor updadeDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}

}
