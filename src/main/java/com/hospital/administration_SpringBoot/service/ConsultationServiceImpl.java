package com.hospital.administration_SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.administration_SpringBoot.DAO.ConsultationDAO;
import com.hospital.administration_SpringBoot.models.Appointment;
import com.hospital.administration_SpringBoot.models.Consultation;

@Service
public class ConsultationServiceImpl implements ConsultationService {
	
	@Autowired
	private ConsultationDAO consultationDAO;

	@Override
	public List<Consultation> getConsultations() {
		
		List<Consultation> CONSULTATIONS = (List<Consultation>) consultationDAO.findAll();
		if(!CONSULTATIONS.isEmpty()) {
			return CONSULTATIONS;
		}
		else {
			return null;
		}
	}

	@Override
	public Consultation saveConsultation(Consultation consultation) {
		
		Consultation _consultation = new Consultation();
		
		_consultation.setId_consultation(consultation.getId_consultation());
		_consultation.setPrice(consultation.getPrice());
		_consultation.setReport(consultation.getReport());
		_consultation.setAppointment(consultation.getAppointment());
		
		consultationDAO.save(_consultation);
		return _consultation;

}

	@Override
	public Consultation getConsultationByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consultation updateConsultation(Long id, Consultation consultation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consultation getConsultationsByAppointement(Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteConsultationByID(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteConsultations() {
		// TODO Auto-generated method stub
		
	}
	
}
