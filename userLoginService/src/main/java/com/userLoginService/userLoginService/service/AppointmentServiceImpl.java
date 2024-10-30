package com.userLoginService.userLoginService.service;

import com.userLoginService.userLoginService.model.Appointment;
import com.userLoginService.userLoginService.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public void scheduleAppointment(Appointment appointment) {
        appointmentRepository.createAppointment(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findAppointmentById(id);
    }

    @Override
    public List<Appointment> getAppointmentsByCustomerName(String customerName) {
        return appointmentRepository.findAppointmentsByCustomerName(customerName);
    }

    @Override
    public List<Appointment> getUpcomingAppointments(LocalDateTime dateTime) {
        return appointmentRepository.findUpcomingAppointments(dateTime, "Scheduled");
    }

    @Override
    public void updateAppointmentStatus(Long id, String status) {
        appointmentRepository.updateAppointmentStatus(id, status);

    }

    @Override
    public void cancelAppointment(Long id) {
        appointmentRepository.updateAppointmentStatus(id, "Cancelled");
    }
}
