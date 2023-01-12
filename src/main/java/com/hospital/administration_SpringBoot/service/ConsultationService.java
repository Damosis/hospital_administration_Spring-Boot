package com.hospital.administration_SpringBoot.service;

import java.util.List;

import com.hospital.administration_SpringBoot.models.Appointment;
import com.hospital.administration_SpringBoot.models.Consultation;

public interface ConsultationService {
	
	List<Consultation> getConsultations();
	
	Consultation saveConsultation(Consultation consultation);
	
	Consultation getConsultationByID(Long id);
	
	Consultation updateConsultation(Long id,Consultation consultation);
	
	Consultation getConsultationsByAppointement(Appointment appointment);
	
	void deleteConsultationByID(Long id);
	
	void deleteConsultations();

}
