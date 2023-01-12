package com.hospital.administration_SpringBoot.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospital.administration_SpringBoot.models.Appointment;
import com.hospital.administration_SpringBoot.models.Consultation;

@Repository
public interface ConsultationDAO extends CrudRepository<Consultation, Long> {
	
	//Consultation findByAppointement(Appointment appointment);
	
}
