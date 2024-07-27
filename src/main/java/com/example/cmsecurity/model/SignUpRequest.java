package com.example.cmsecurity.model;

import com.example.cmsecurity.enums.Role;
import lombok.Data;

@Data
public class SignUpRequest {

    private String username;
    private String email;
    private String password;
    private Role role;
}
