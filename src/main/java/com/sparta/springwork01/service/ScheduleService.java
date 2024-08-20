package com.sparta.springwork01.service;

import com.sparta.springwork01.dto.ScheduleRequestDto;
import com.sparta.springwork01.dto.ScheduleResponseDto;
import com.sparta.springwork01.entity.Schedule;
import com.sparta.springwork01.repository.ScheduleRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule(scheduleRequestDto);

        Schedule saveSchedule = scheduleRepository.save(schedule);


        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);

        return scheduleResponseDto;
    }

    public List<ScheduleResponseDto> getAllSchedules() {
        return scheduleRepository.findAll();
    }


    public Long updateSchedule(Long id, ScheduleRequestDto scheduleRequestDto) {

        try {
            Schedule schedule = scheduleRepository.findById(id);
            if(schedule != null){
                scheduleRepository.update(id, scheduleRequestDto);
                return id;
            } else {
                throw new IllegalArgumentException("Schedule not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating schedule: " + e.getMessage());
        }
    }


    public Long deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id);
        if(schedule != null) {
            scheduleRepository.delete(id);
            return id;
        } else {
            throw new IllegalArgumentException("Schedule not found");
        }
    }
}
