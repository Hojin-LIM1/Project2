package com.example.project2.schedule.service;


import com.example.project2.schedule.dto.*;
import com.example.project2.schedule.entity.Schedule;
import com.example.project2.schedule.repository.ScheduleRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ScheduleService {

    private final ScheduleRepository scheduleRepository;


    //생성
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(request.getAuthor(),
                request.getTitle(),
                request.getContent()

        );
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getAuthor(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getCreateDate(),
                savedSchedule.getUpdateDate()
        );
    }

    //단건 조회
    @Transactional(readOnly = true)
    public GetScheduleResponse getOne(Long scheduleID) {
        Schedule schedule = scheduleRepository.findById(scheduleID).orElseThrow(
                () -> new IllegalStateException("해당 스케줄은 없습니다.")
        );
        return new GetScheduleResponse(
                schedule.getId(),
                schedule.getAuthor(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCreateDate(),
                schedule.getUpdateDate()

        );
    }

    // 수정
    @Transactional
    public UpdateScheduleResponse update(Long scheduleId, UpdateScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("해당 일정은 존재하지 않습니다.")
        );

        schedule.update(request.getAuthor(), request.getTitle(), request.getContent());
        return new UpdateScheduleResponse(
                schedule.getId(),
                schedule.getAuthor(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCreateDate(),
                schedule.getUpdateDate()

        );

    }

    //삭제
    @Transactional
    public void delete(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("해당 일정은 존재하지 않습니다.")
        );
        scheduleRepository.delete(schedule);

    }


}
