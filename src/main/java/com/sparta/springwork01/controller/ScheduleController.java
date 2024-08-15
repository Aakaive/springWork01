package com.sparta.springwork01.controller;

import com.sparta.springwork01.dto.ScheduleRequestDto;
import com.sparta.springwork01.dto.ScheduleResponseDto;
import com.sparta.springwork01.entity.Schedule;
import com.sparta.springwork01.service.ScheduleService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/Schedules")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        ScheduleService scheduleService = new ScheduleService();
        return scheduleService.createSchedule();
    }

}
