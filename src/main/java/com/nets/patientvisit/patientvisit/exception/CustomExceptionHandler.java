package com.nets.patientvisit.patientvisit.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> customHandleNotFound(Exception ex, WebRequest request) {

        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, LocalDateTime.now(), ex.getMessage(), ex.getLocalizedMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
}
