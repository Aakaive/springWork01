package com.sparta.springwork01.controller;

import com.sparta.springwork01.dto.ScheduleRequestDto;
import com.sparta.springwork01.dto.ScheduleResponseDto;
import com.sparta.springwork01.entity.Schedule;
import com.sparta.springwork01.service.ScheduleService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/schedules")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.createSchedule(scheduleRequestDto);
    }

    @GetMapping("/schedules")
    public List<ScheduleResponseDto> getAllSchedules() {
        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.getAllSchedules();
    }

    @PutMapping("/schedules/{id}")
    public Long updateSchedule(@PathVariable("id") Long id, @RequestBody ScheduleRequestDto scheduleRequestDto) {
        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.updateSchedule(id, scheduleRequestDto);
    }

    @DeleteMapping("/schedules/{id}")
    public Long deleteSchedule(@PathVariable("id") Long id) {
        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.deleteSchedule(id);
    }
}
