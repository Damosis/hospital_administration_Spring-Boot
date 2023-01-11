package com.hospital.administration_SpringBoot.service;

import java.util.List;

import com.hospital.administration_SpringBoot.models.Consultation;
import com.hospital.administration_SpringBoot.models.Patient;

public interface PatientService {
	
	List<Patient> getPatients();
	
	Patient savePatient(Patient patient);
	
	Patient getPatientByID(Long id);
	
	Patient updatePatient(Long id,Patient patient);
	
	Patient getPatientByConsultation(Consultation consultation);
	
	void deleteByID(Long id);
	
	void deletePatients();

}
