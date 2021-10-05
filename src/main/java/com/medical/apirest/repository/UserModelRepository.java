package com.medical.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.apirest.models.UserModel;

import java.util.Optional;

public interface UserModelRepository extends JpaRepository<UserModel, Integer> {

    public Optional<UserModel> findByLogin(String login);

}
