package com.example.project2.user.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@Table()
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @CreatedDate
    @Column(updatable = false, nullable=false)
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime updateDate;

    public User(String name, String email) {
        this.name = name;
        this.email = email;

    }

    public void update(String name, String email){
        this.name = name;
        this.email = email;
    }

}
