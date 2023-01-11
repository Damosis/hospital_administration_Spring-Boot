package com.hospital.administration_SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.administration_SpringBoot.DAO.ConsultationDAO;
import com.hospital.administration_SpringBoot.models.Consultation;
import com.hospital.administration_SpringBoot.models.Doctor;
import com.hospital.administration_SpringBoot.models.Patient;

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
		_consultation.setDateConsultation(consultation.getDateConsultation());
		_consultation.setPatient(consultation.getPatient());
		_consultation.setDoctor(consultation.getDoctor());
		
		consultationDAO.save(_consultation);
		return _consultation;
		
//	 Consultation savedConsultation = consultationDAO.save(new Consultation(consultation.getTitle(),consultation.getAuthor(),consultation.getPrice()));
//	 return savedConsultation;
		
	}

	@Override
	public Consultation getConsultationByID(Long id) {
		
		Optional<Consultation> retrievedConsultation = consultationDAO.findById(id);
		if(retrievedConsultation.isPresent()) {
			return retrievedConsultation.get();
		}
		else {
			return null;
		}
		
	}

	@Override
	public Consultation updateConsultation(Long id, Consultation consultation) {
		
		Optional<Consultation> retrievedConsultation = consultationDAO.findById(id);
		
		Consultation _consultation = retrievedConsultation.get();
		
		_consultation.setId_consultation(consultation.getId_consultation());
		_consultation.setDateConsultation(consultation.getDateConsultation());
		_consultation.setPatient(consultation.getPatient());
		_consultation.setDoctor(consultation.getDoctor());
		
		consultationDAO.save(_consultation);
		return _consultation;
	}

	@Override
	public void deleteConsultationByID(Long id) {
		consultationDAO.deleteById(id);
		
	}

	@Override
	public void deleteConsultations() {
		consultationDAO.deleteAll();
	}

	@Override
	public List<Consultation> getConsultationsByDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		List<Consultation> consultations = consultationDAO.findByDoctor(doctor);
		if(!consultations.isEmpty()) {
			return consultations;
		}
		return null;
	}
	
	@Override
	public List<Consultation> getConsultationsByPatient(Patient patient) {
		// TODO Auto-generated method stub
		List<Consultation> consultations = consultationDAO.findByPatient(patient);
		if(!consultations.isEmpty()) {
			return consultations;
		}
		return null;
	}

}
