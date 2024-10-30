package com.userLoginService.userLoginService.service;

import com.userLoginService.userLoginService.model.Appointment;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
    void scheduleAppointment(Appointment appointment);
    Appointment getAppointmentById(Long id);
    List<Appointment> getAppointmentsByCustomerName(String customerName);
    List<Appointment> getUpcomingAppointments(LocalDateTime dateTime);
    void updateAppointmentStatus(Long id, String status);
    void cancelAppointment(Long id);
}
