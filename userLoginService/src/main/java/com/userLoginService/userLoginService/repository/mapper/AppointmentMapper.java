package com.userLoginService.userLoginService.repository.mapper;

import com.userLoginService.userLoginService.model.Appointment;
import com.userLoginService.userLoginService.model.AppointmentStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component

public class AppointmentMapper implements RowMapper<Appointment> {
    @Override
    public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Appointment appointment = new Appointment(
                rs.getLong("id"),
                rs.getString("customer_name"),
                rs.getTimestamp("appointment_time").toLocalDateTime(),
                AppointmentStatus.valueOf(rs.getString("status")));

        return appointment;
    }
}
