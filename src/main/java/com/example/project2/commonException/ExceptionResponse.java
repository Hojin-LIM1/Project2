package com.example.project2.commonException;

import lombok.Getter;

@Getter
public class ExceptionResponse {
    private final String message;
    private final int status;


    public ExceptionResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
