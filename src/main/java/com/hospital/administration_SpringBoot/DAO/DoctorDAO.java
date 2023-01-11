package com.hospital.administration_SpringBoot.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospital.administration_SpringBoot.models.Consultation;
import com.hospital.administration_SpringBoot.models.Doctor;

@Repository
public interface DoctorDAO extends CrudRepository<Doctor, Long> {
	//Doctor findByConsultation(Consultation consultation);
}
