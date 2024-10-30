package com.userLoginService.userLoginService.repository;

import com.userLoginService.userLoginService.model.Appointment;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository {
    void createAppointment(Appointment appointment);
    Appointment findAppointmentById(Long id);
    List<Appointment> findAppointmentsByCustomerName(String customerName);
    List<Appointment> findUpcomingAppointments(LocalDateTime dateTime, String status);
    void updateAppointmentStatus(Long id, String status);
    void deleteAppointment(Long id);
}
