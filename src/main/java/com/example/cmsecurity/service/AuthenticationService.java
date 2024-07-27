package com.example.cmsecurity.service;

import com.example.cmsecurity.entity.UserEntity;
import com.example.cmsecurity.model.JwtAuthenticationResponse;
import com.example.cmsecurity.model.SignInRequest;
import com.example.cmsecurity.model.SignUpRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public record AuthenticationService(UserService userService,
                                    JwtService jwtService,
                                    PasswordEncoder passwordEncoder,
                                    AuthenticationManager authenticationManager) {

    public JwtAuthenticationResponse signUp(SignUpRequest request){
        var user = UserEntity.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userService.create(user);

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }

    public JwtAuthenticationResponse signIn(SignInRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));
        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }
}
