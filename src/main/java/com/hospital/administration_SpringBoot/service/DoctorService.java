package com.hospital.administration_SpringBoot.service;

import java.util.List;

import com.hospital.administration_SpringBoot.models.Consultation;
import com.hospital.administration_SpringBoot.models.Doctor;

public interface DoctorService {
	
	List<Doctor> getDoctors();
	
	Doctor saveDoctor(Doctor doctor);
	
	Doctor getDoctorByID(Long id);
	
	Doctor updateDoctor(Long id, Doctor doctor);
	
	Doctor getDoctorByConsultation(Consultation consultation);
	
	void deleteByID(Long id);
	
	void deleteDoctors();

}
