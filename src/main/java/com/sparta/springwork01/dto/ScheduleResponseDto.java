package com.sparta.springwork01.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String contents;
    private String username;
    private String password;
    private LocalDateTime date;

    public ScheduleResponseDto(Long id, String contents, String username, String password, LocalDateTime date) {
        this.id = id;
        this.contents = contents;
        this.username = username;
        this.password = password;
        this.date = date;
    }
}
