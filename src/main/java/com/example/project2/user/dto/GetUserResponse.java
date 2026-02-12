package com.example.project2.user.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetUserResponse {
    private final Long id;
    private final String name;
    private final String email;
    private final LocalDateTime createDate;
    private final LocalDateTime updateDate;

    public GetUserResponse(Long id, String name, String email, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
