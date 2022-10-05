package com.pharaphara.downloadManagerApi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);



    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<ApiException> handleWebClientResponseException(WebClientResponseException ex) {
        ApiException apiException = new ApiException(ex.getMessage(), ex.getResponseBodyAsString(), ex.getStatusCode(), ZonedDateTime.now(ZoneId.of("Z")));
        logger.error(apiException.toString());
        return ResponseEntity.badRequest().body(apiException);
    }

   /* @ExceptionHandler(JMSException.class)
    public ResponseEntity<String> handleJMSException(JMSException ex) {
        //logger.error("Error from WebClient - Status {}, Body {}", ex.getRawStatusCode(),                ex.getResponseBodyAsString(), ex);
        return ResponseEntity..body(ex.getMessage()));
    }*/

   /* @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException (ApiRequestException e){

        ApiException apiException = new ApiException(e.getMessage()+"par la", e.getCause(), HttpStatus.BAD_GATEWAY, ZonedDateTime.now(ZoneId.of("Z")));

        return ResponseEntity.badRequest().body(apiException);
    }*/


}
