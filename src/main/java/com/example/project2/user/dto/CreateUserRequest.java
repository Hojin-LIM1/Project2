package com.example.project2.user.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateUserRequest {

    private String name;
    private String email;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;


}
