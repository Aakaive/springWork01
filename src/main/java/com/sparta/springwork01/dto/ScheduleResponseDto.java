package com.sparta.springwork01.dto;

import com.sparta.springwork01.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String contents;
    private String username;
    private String password;
    private Date date;

    public ScheduleResponseDto(Long id, String contents, String username, String password, Date date) {
        this.id = id;
        this.contents = contents;
        this.username = username;
        this.password = password;
        this.date = date;
    }

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.contents = schedule.getContents();
        this.username = schedule.getUsername();
        this.password = schedule.getPassword();
        this.date = schedule.getDate();
    }
}
