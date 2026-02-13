package com.example.project2.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateUserRequest {

    @NotBlank(message = "이름을 입력해주세요")
    private String name;
    @Email(message = "이메일 형식이 아닙니다. ex) aaaa@email.com")
    private String email;

    @Size(min = 8, message = "비밀번호는 8자 이상이여야 합니다.")
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;


}
