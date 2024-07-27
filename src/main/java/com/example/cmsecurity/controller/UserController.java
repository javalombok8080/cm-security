package com.example.cmsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {

    @GetMapping("/user")
    public String getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Hello user" + authentication.getName();
    }

    @GetMapping("/admin")
    public String getAmin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Hello admin" + authentication.getName();
    }
}

