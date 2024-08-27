package com.example.cmsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {

    @GetMapping("/teacher")
    public String getUser(){
        return "Hello user";
    }

    @GetMapping("/admin")
    public String getAmin(){
        return "Hello admin";
    }
}

