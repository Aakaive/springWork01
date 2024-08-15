package com.sparta.springwork01.entity;


import com.sparta.springwork01.dto.ScheduleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Schedule {
    private Long id;
    private String contents;
    private String username;
    private String password;
    private LocalDateTime date;


    public Schedule(ScheduleRequestDto scheduleRequestDto) {
        this.id = scheduleRequestDto.getId();
        this.contents = scheduleRequestDto.getContents();
        this.username = scheduleRequestDto.getUsername();
        this.password = scheduleRequestDto.getPassword();
        this.date = scheduleRequestDto.getDate();
    }

    public void update(ScheduleRequestDto requestDto) {
        this.id = requestDto.getId();
        this.contents = requestDto.getContents();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.date = requestDto.getDate();
    }
}
