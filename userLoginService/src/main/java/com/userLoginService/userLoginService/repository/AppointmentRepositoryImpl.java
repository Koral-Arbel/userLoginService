package com.userLoginService.userLoginService.repository;

import com.userLoginService.userLoginService.model.Appointment;
import com.userLoginService.userLoginService.repository.mapper.AppointmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {

    private static final String APPOINTMENT_TABLE_NAME = "appointments";


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createAppointment(Appointment appointment) {
        String sql = "INSERT INTO " + APPOINTMENT_TABLE_NAME + " (customer_name, appointment_time, status) VALUES (?, ?, ?)";
        try {
            jdbcTemplate.update(sql, appointment.getCustomerName(), appointment.getAppointmentTime(), appointment.getStatus().toString());
        } catch (Exception e) {
            e.printStackTrace(); // הדפס את השגיאה לטרמינל
            throw e; // אם תרצה להמשיך לזרוק את השגיאה
        }
    }

    @Override
    public Appointment findAppointmentById(Long id) {
        String sql = "SELECT * FROM " + APPOINTMENT_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new AppointmentMapper(), id);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public List<Appointment> findAppointmentsByCustomerName(String customerName) {
        String sql = "SELECT * FROM " + APPOINTMENT_TABLE_NAME + " WHERE customer_name=?";
        return jdbcTemplate.query(sql, new AppointmentMapper(), customerName);
    }

    @Override
    public List<Appointment> findUpcomingAppointments(LocalDateTime dateTime, String status) {
        String sql = "SELECT * FROM " + APPOINTMENT_TABLE_NAME + " WHERE appointment_time > ? AND status = ?";
        return jdbcTemplate.query(sql, new AppointmentMapper(), dateTime, status);
    }

    @Override
    public void updateAppointmentStatus(Long id, String status) {
        String sql = "UPDATE " + APPOINTMENT_TABLE_NAME + " SET status = ? WHERE id = ?";
        jdbcTemplate.update(sql, status, id);
    }

    @Override
    public void deleteAppointment(Long id) {
        String sql = "DELETE FROM " + APPOINTMENT_TABLE_NAME + " WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
