package com.medical.apirest.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medical.apirest.models.UserModel;


public interface UserModelLogin extends JpaRepository<UserModel, Integer> {
	
	@Query("SELECT u.id, u.name, u.login, u.email FROM UserModel u WHERE u.login = ?1")
	Object getUserByLogin(String login);
	
    
}
