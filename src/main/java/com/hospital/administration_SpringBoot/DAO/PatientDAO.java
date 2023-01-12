package com.hospital.administration_SpringBoot.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospital.administration_SpringBoot.models.Appointment;
import com.hospital.administration_SpringBoot.models.Patient;

@Repository
public interface PatientDAO extends CrudRepository<Patient, Long> {
	//Patient findByAppointment(Appointment appointment);
}
