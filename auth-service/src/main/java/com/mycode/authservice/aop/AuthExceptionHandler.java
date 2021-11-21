package com.mycode.authservice.aop;

import com.mycode.authservice.exceptions.AuthServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler(AuthServiceException.class)
    public ResponseEntity<?> authServiceException(AuthServiceException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), ex.getResponseStatus());
    }
}
