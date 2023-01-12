package com.hospital.administration_SpringBoot.service;

import java.util.List;

import com.hospital.administration_SpringBoot.models.Appointment;
import com.hospital.administration_SpringBoot.models.Doctor;

public interface DoctorService {
	
	List<Doctor> getDoctors();
	
	Doctor saveDoctor(Doctor doctor);
	
	Doctor getDoctorByID(Long id);
	
	Doctor updateDoctor(Long id, Doctor doctor);
	
	Doctor getDoctorByAppointment(Appointment appointment);
	
	void deleteByID(Long id);
	
	void deleteDoctors();

}
