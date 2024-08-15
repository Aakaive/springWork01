package com.sparta.springwork01.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {
    private Long id;
    private String contents;
    private String username;
    private String password;
    private LocalDateTime date;
}
