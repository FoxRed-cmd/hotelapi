package com.mydom.hotelapi.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    private final HttpStatus errorStatus;

    public ApiException(HttpStatus errorStatus, String message) {
        super(message);
        this.errorStatus = errorStatus;
    }

    public HttpStatus getErrorStatus() {
        return errorStatus;
    }
}
