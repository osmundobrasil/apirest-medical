package com.medical.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.medical.apirest.data.DetailUserData;
import com.medical.apirest.models.UserModel;
import com.medical.apirest.repository.UserModelRepository;

import java.util.Optional;

@Component
public class DetailUserServiceImpl implements UserDetailsService {

    //private final UsuarioRepository userModelRepository;
    @Autowired
	UserModelRepository userModelRepository;

    public DetailUserServiceImpl(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> userModel = userModelRepository.findByLogin(username);
        if (userModel.isEmpty()) {
            throw new UsernameNotFoundException("User [" + username + "] not found.");
        }

        return new DetailUserData(userModel);
    }

}
