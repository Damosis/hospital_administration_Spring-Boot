package com.hospital.administration_SpringBoot.service;

import java.util.List;

import com.hospital.administration_SpringBoot.models.Consultation;
import com.hospital.administration_SpringBoot.models.Doctor;
import com.hospital.administration_SpringBoot.models.Patient;

public interface ConsultationService {
	
	List<Consultation> getConsultations();
	
	Consultation saveConsultation(Consultation consultation);
	
	Consultation getConsultationByID(Long id);
	
	Consultation updateConsultation(Long id,Consultation consultation);
	
	List<Consultation> getConsultationsByDoctor(Doctor doctor);
	
	List<Consultation> getConsultationsByPatient(Patient patient);
	
	void deleteConsultationByID(Long id);
	
	void deleteConsultations();

}
