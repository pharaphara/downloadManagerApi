package com.pharaphara.downloadManagerApi.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {
    private final String httpMessage;
    private final String errorMessage;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;


    public ApiException(String message, String errorMessage, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.httpMessage = message;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getHttpMessage() {
        return httpMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }



    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "httpMessage='" + httpMessage + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", httpStatus=" + httpStatus +
                ", timestamp=" + timestamp +
                '}';
    }
}
