package com.example.project2.commonException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ExceptionResponse> handleUserException(UserException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), ex.getStatus().value());

        return ResponseEntity
                .status((ex.getStatus()))
                .body(exceptionResponse);
    }

    @ExceptionHandler(ScheduleException.class)
    public ResponseEntity<ExceptionResponse> handleScheduleException(ScheduleException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), ex.getStatus().value());
        return ResponseEntity
                .status((ex.getStatus()))
                .body(exceptionResponse);
    }

}
