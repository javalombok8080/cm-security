package com.example.cmsecurity.exception;

import com.example.cmsecurity.exception.model.ErrorModel;
import com.example.cmsecurity.exception.model.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UserAlreadyExistException.class)
    public ResponseEntity<ErrorModel> getCustomerAlreadyException(UserAlreadyExistException ex){
        var errorModel = new ErrorModel(HttpStatus.ALREADY_REPORTED.value(), ex.getMessage());
        log.error(String.valueOf(errorModel));
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(errorModel);
    }
}
