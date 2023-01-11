package com.hospital.administration_SpringBoot.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospital.administration_SpringBoot.models.Consultation;
import com.hospital.administration_SpringBoot.models.Doctor;
import com.hospital.administration_SpringBoot.models.Patient;

@Repository
public interface ConsultationDAO extends CrudRepository<Consultation, Long> {
	
	List<Consultation> findByDoctor(Doctor doctor);
	List<Consultation> findByPatient(Patient patient);
	
}
