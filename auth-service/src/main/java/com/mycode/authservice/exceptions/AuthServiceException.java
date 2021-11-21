package com.mycode.authservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AuthServiceException extends RuntimeException {
    private final HttpStatus responseStatus;


    public AuthServiceException(HttpStatus responseStatus, String message) {
        super(message);
        this.responseStatus = responseStatus;
    }

    public HttpStatus getResponseStatus() {
        return responseStatus;
    }
}
