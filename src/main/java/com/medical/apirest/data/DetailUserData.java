package com.medical.apirest.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.medical.apirest.models.UserModel;
import com.medical.apirest.repository.UserModelRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetailUserData implements UserDetails {

    @Autowired
    Optional<UserModel> userModel;


    public DetailUserData(Optional<UserModel> userModel) {
        this.userModel = userModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return userModel.orElse(new UserModel()).getPassword();
    }

    @Override
    public String getUsername() {
        return userModel.orElse(new UserModel()).getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
