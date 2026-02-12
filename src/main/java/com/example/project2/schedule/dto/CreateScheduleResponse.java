package com.example.project2.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class CreateScheduleResponse {
    private final Long id;
    private final String author;
    private final String title;
    private final String content;
    private final LocalDateTime createDate;
    private final LocalDateTime updateDate;

    public CreateScheduleResponse(Long id, String author, String title, String content, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
