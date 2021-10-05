package com.medical.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.apirest.models.UserModel;
import com.medical.apirest.repository.UserModelRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Medical")
public class UserModelResource {
	
	@Autowired
	UserModelRepository userModelRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	public UserModelResource(UserModelRepository userModelRepository, PasswordEncoder encoder) {
        this.userModelRepository = userModelRepository;
        this.encoder = encoder;
    }
	
	
	@ApiOperation(value="Get list users")
	@GetMapping("/users")
	public List<UserModel> ListUsers(){
		return userModelRepository.findAll();
	}
	
//	//@ApiOperation(value="Get single doctor")
//	@GetMapping("/doctor/{id}")
//	public Doctor SingleDoctorList(@PathVariable(value="id") long id){
//		return doctorRepository.findById(id);
//	}
	
	@ApiOperation(value="Save user")
	@PostMapping("/user")
	public UserModel saveUser(@RequestBody UserModel user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userModelRepository.save(user);
	}
	
//	//@ApiOperation(value="Delete doctor")
//	@DeleteMapping("/doctor")
//	@PreAuthorize("hasRole('ADMIN')")
//	public void deleteDoctor(@RequestBody Doctor doctor) {
//		doctorRepository.delete(doctor);
//	}
//	
//	//@ApiOperation(value="Update doctor")
//	@PutMapping("/doctor")
//	public Doctor updadeDoctor(@RequestBody Doctor doctor) {
//		return doctorRepository.save(doctor);
//	}
	
	@ApiOperation(value="Validate password")
	@GetMapping("/validatePassword")
    public ResponseEntity<Boolean> validatePassword(@RequestParam String login,
                                                	@RequestParam String password) {
		
        Optional<UserModel> optUser = userModelRepository.findByLogin(login);
        if (optUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        UserModel UserModel = optUser.get();
        boolean valid = encoder.matches(password, UserModel.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);

    }

}
