package com.example.project2.user.controller;


import com.example.project2.user.dto.*;
import com.example.project2.user.repository.UserRepository;
import com.example.project2.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//확인
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;


    @PostMapping("/user")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
        CreateUserResponse result = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


    //단건조회
    @GetMapping("/user/{userId}")
    public ResponseEntity<GetUserResponse> getUser(@PathVariable long userId) {
        GetUserResponse result = userService.getUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    //수정
    @PutMapping("/user/{userId}")
    public ResponseEntity<UpdateUserResponse> update(
            @PathVariable Long userId,
            @RequestBody UpdateUserRequest request
    ){
        UpdateUserResponse result = userService.update(userId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //삭제
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long userId
    ) {
        userService.delete(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody LoginRequest request, HttpSession session) {
        SessionUser sessionUser = userService.login(request);
        session.setAttribute("LoginUser", sessionUser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

