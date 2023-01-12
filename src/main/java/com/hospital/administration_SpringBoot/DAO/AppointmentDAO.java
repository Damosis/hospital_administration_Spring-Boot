package com.hospital.administration_SpringBoot.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospital.administration_SpringBoot.models.Appointment;
import com.hospital.administration_SpringBoot.models.Doctor;
import com.hospital.administration_SpringBoot.models.Patient;

@Repository
public interface AppointmentDAO extends CrudRepository<Appointment, Long> {
	
	List<Appointment> findByDoctor(Doctor doctor);
	List<Appointment> findByPatient(Patient patient);
	
}
