package com.example.project2.user.service;


import com.example.project2.user.dto.*;
import com.example.project2.user.entity.User;
import com.example.project2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;


    //생성
    @Transactional
    public CreateUserResponse save(CreateUserRequest request) {
        User user = new User(request.getName(), request.getEmail(), request.getPassword());
        User savedUser = userRepository.save(user);

        return new CreateUserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getCreateDate(),
                savedUser.getUpdateDate()
        );
    }

    //단건 조회
    @Transactional(readOnly = true)
    public GetUserResponse getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("해당 유저는 없습니다.")
        );
        return new GetUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreateDate(),
                user.getUpdateDate()

        );
    }

    // 수정
    @Transactional
    public UpdateUserResponse update(Long userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("해당 유저는 존재하지 않습니다.")
        );

        user.update(request.getName(), request.getEmail(), request.getPassword());
        return new UpdateUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreateDate(),
                user.getUpdateDate()

        );

    }

    //삭제
    @Transactional
    public void delete(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("해당 유저는 존재하지 않습니다.")
        );
        userRepository.delete(user);

    }


}
