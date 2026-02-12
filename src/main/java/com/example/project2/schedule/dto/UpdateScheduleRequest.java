package com.example.project2.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleRequest {
    private String author;
    private String title;
    private String content;

}
