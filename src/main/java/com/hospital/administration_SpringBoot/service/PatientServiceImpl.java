package com.hospital.administration_SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.administration_SpringBoot.DAO.PatientDAO;
import com.hospital.administration_SpringBoot.models.Consultation;
import com.hospital.administration_SpringBoot.models.Patient;


@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientDAO patientDAO;

	@Override
	public List<Patient> getPatients() {
		
		List<Patient> PATIENTS = (List<Patient>) patientDAO.findAll();
		if(!PATIENTS.isEmpty()) {
			return PATIENTS;
		}
		else {
			return null;
		}
	}

	@Override
	public Patient savePatient(Patient patient) {
		
		Patient _patient = new Patient();
		_patient.setFirstname(patient.getFirstname());
		_patient.setLastname(patient.getLastname());
		_patient.setConsultations(patient.getConsultations());
		patientDAO.save(_patient);
		return _patient;
		
//	 Patient savedPatient = patientDAO.save(new Patient(patient.getTitle(),patient.getAuthor(),patient.getPrice()));
//	 return savedPatient;
		
	}

	@Override
	public Patient getPatientByID(Long id) {
		
		Optional<Patient> retrievedPatient = patientDAO.findById(id);
		if(retrievedPatient.isPresent()) {
			return retrievedPatient.get();
		}
		else {
			return null;
		}
		
	}

	@Override
	public Patient updatePatient(Long id, Patient patient) {
		
		Optional<Patient> retrievedPatient = patientDAO.findById(id);
		
		Patient _patient = retrievedPatient.get();
		
		_patient.setFirstname(patient.getFirstname());
		_patient.setLastname(patient.getLastname());
		_patient.setConsultations(patient.getConsultations());
		
		patientDAO.save(_patient);
		return _patient;
	}

	@Override
	public void deleteByID(Long id) {
		patientDAO.deleteById(id);
		
	}

	@Override
	public void deletePatients() {
		patientDAO.deleteAll();
	}

	@Override
	public Patient getPatientByConsultation(Consultation consultation) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Patient getPatientByConsultation(Consultation consultation) {
		// TODO Auto-generated method stub
		Patient patient = patientDAO.findByConsultation(consultation);
		if(!(patient == null)) {
			return patient;
		}
		return null;
	}*/

}
