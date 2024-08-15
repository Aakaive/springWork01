package com.sparta.springwork01.service;

import com.sparta.springwork01.dto.ScheduleRequestDto;
import com.sparta.springwork01.dto.ScheduleResponseDto;
import com.sparta.springwork01.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ScheduleService {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule(scheduleRequestDto);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO schedule (contents, username, password, date) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update( con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, schedule.getContents());
            preparedStatement.setString(2, schedule.getUsername());
            preparedStatement.setString(3, schedule.getPassword());
            preparedStatement.setObject(4, schedule.getDate());
            return preparedStatement;
        }, keyHolder);

        Long id = keyHolder.getKey().longValue();
        schedule.setId(id);

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);

        return scheduleResponseDto;
    }

    public List<ScheduleResponseDto> getAllSchedules() {
        String sql = "SELECT * FROM schedule";

        return jdbcTemplate.query(sql, new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int i) throws SQLException {
                Long id = rs.getLong("id");
                String contents = rs.getString("contents");
                String username = rs.getString("username");
                String password = rs.getString("password");
                Date date = rs.getDate("date");
                return new ScheduleResponseDto(id, contents, username, password, date);
            }
        });
    }


    public Long updateSchedule(Long id, ScheduleRequestDto scheduleRequestDto) {
        try {
            Schedule schedule = findById(id);
            if(schedule != null){
                String sql = "UPDATE schedule SET contents = ?, username = ?, date = ? WHERE id = ?";
                Timestamp timestamp = new Timestamp(scheduleRequestDto.getDate().getTime());
                jdbcTemplate.update(sql, scheduleRequestDto.getContents(), scheduleRequestDto.getUsername(), timestamp, id);
                return id;
            } else {
                throw new IllegalArgumentException("Schedule not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating schedule: " + e.getMessage());
        }
    }

    private Schedule findById(Long id) {
        String sql = "SELECT * FROM schedule WHERE id = ?";

        return jdbcTemplate.query(sql, resultSet -> {
            if (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setUsername(resultSet.getString("username"));
                schedule.setContents(resultSet.getString("contents"));
                Date date = new Date();
                schedule.setDate(date);
                return schedule;
            } else {
                return null;
            }
        }, id);
    }

    public Long deleteSchedule(Long id) {
        Schedule schedule = findById(id);
        if(schedule != null) {
            String sql = "DELETE FROM schedule WHERE id = ?";
            jdbcTemplate.update(sql, id);

            return id;
        } else {
            throw new IllegalArgumentException("Schedule not found");
        }
    }
}
