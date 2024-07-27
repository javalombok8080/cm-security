package com.example.cmsecurity.exception.model;

public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException() {}

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
