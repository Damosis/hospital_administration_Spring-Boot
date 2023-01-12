package com.hospital.administration_SpringBoot.service;

import java.util.List;

import com.hospital.administration_SpringBoot.models.Appointment;
import com.hospital.administration_SpringBoot.models.Doctor;
import com.hospital.administration_SpringBoot.models.Patient;

public interface AppointmentService {
	
	List<Appointment> getAppointments();
	
	Appointment saveAppointment(Appointment appointment);
	
	Appointment getAppointmentByID(Long id);
	
	Appointment updateAppointment(Long id,Appointment appointment);
	
	List<Appointment> getAppointmentsByDoctor(Doctor doctor);
	
	List<Appointment> getAppointmentsByPatient(Patient patient);
	
	void deleteAppointmentByID(Long id);
	
	void deleteAppointments();

}
