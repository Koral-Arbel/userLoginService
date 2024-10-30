package com.userLoginService.userLoginService.controller;

import com.userLoginService.userLoginService.model.Appointment;
import com.userLoginService.userLoginService.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/public/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/schedule")
    @CrossOrigin
    public void scheduleAppointment(@RequestBody Appointment appointment) {
        appointmentService.scheduleAppointment(appointment);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @GetMapping("/customer/{name}")
    @CrossOrigin
    public List<Appointment> getAppointmentsByCustomerName(@PathVariable String name) {
        return appointmentService.getAppointmentsByCustomerName(name);
    }

    @GetMapping("/upcoming")
    @CrossOrigin
    public List<Appointment> getUpcomingAppointments() {
        return appointmentService.getUpcomingAppointments(LocalDateTime.now());
    }

    @PutMapping("/{id}/status")
    @CrossOrigin
    public void updateAppointmentStatus(@PathVariable Long id, @RequestParam String status) {
        appointmentService.updateAppointmentStatus(id, status);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public void cancelAppointment(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
    }
}
