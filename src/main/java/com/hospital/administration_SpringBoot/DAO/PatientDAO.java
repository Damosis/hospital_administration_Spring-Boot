package com.hospital.administration_SpringBoot.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospital.administration_SpringBoot.models.Consultation;
import com.hospital.administration_SpringBoot.models.Patient;

@Repository
public interface PatientDAO extends CrudRepository<Patient, Long> {
	//Patient findByConsultation(Consultation consultation);
}
