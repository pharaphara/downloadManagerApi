package com.pharaphara.downloadManagerApi.exception;

public class ApiRequestException extends RuntimeException{

    public ApiRequestException (String message) {
        super(message);
    }

    public ApiRequestException (String message, Throwable cause) {
        super(message, cause);
    }
}