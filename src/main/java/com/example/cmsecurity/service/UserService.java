package com.example.cmsecurity.service;

import com.example.cmsecurity.entity.UserEntity;
import com.example.cmsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService  {
    private final UserRepository userRepo;

    public void create(UserEntity userEntity){
        userRepo.save(userEntity);
    }

    public UserEntity getByUsername(String username){
        return userRepo.findByUsername(username).orElseThrow();
    }

    public UserDetailsService userDetailsService(){
        return this::getByUsername;
    }
}