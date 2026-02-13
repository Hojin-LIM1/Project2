package com.example.project2.commonException;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ScheduleException extends RuntimeException{

    private final HttpStatus status;

    public ScheduleException(HttpStatus status, String message) {

        super(message);
        this.status = status;
    }

}
