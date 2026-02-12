package com.example.project2.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleRequest {

    private String author;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;


}
