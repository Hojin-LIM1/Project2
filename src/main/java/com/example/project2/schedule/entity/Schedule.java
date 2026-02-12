package com.example.project2.schedule.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@Table()
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private String content;
    @CreatedDate
    @Column(updatable = false, nullable=false)
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime updateDate;

    public Schedule(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public void update(String author, String title, String content){
        this.author = author;
        this.title = title;
        this.content = content;
    }

}
