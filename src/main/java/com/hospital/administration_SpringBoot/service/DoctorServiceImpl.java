package com.hospital.administration_SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.administration_SpringBoot.DAO.DoctorDAO;
import com.hospital.administration_SpringBoot.models.Appointment;
import com.hospital.administration_SpringBoot.models.Doctor;


@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorDAO doctorDAO;

	@Override
	public List<Doctor> getDoctors() {
		
		List<Doctor> DOCTOR = (List<Doctor>) doctorDAO.findAll();
		if(!DOCTOR.isEmpty()) {
			return DOCTOR;
		}
		else {
			return null;
		}
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		
		Doctor _doctor = new Doctor();
		_doctor.setFirstname(doctor.getFirstname());
		_doctor.setLastname(doctor.getLastname());
		_doctor.setAppointments(doctor.getAppointments());
		doctorDAO.save(_doctor);
		return _doctor;
		
//	 Doctor savedDoctor = doctorDAO.save(new Doctor(doctor.getTitle(),doctor.getAuthor(),doctor.getPrice()));
//	 return savedDoctor;
		
	}

	@Override
	public Doctor getDoctorByID(Long id) {
		
		Optional<Doctor> retrievedDoctor = doctorDAO.findById(id);
		if(retrievedDoctor.isPresent()) {
			return retrievedDoctor.get();
		}
		else {
			return null;
		}
		
	}

	@Override
	public Doctor updateDoctor(Long id, Doctor doctor) {
		
		Optional<Doctor> retrievedDoctor = doctorDAO.findById(id);
		
		Doctor _doctor = retrievedDoctor.get();
		
		_doctor.setFirstname(doctor.getFirstname());
		_doctor.setLastname(doctor.getLastname());
		_doctor.setAppointments(doctor.getAppointments());
		
		doctorDAO.save(_doctor);
		return _doctor;
	}

	@Override
	public void deleteByID(Long id) {
		doctorDAO.deleteById(id);
		
	}

	@Override
	public void deleteDoctors() {
		doctorDAO.deleteAll();
	}

	@Override
	public Doctor getDoctorByAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Doctor getDoctorByAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		Doctor doctor = doctorDAO.findByAppointment(appointment);
		if(!(doctor == null)) {
			return doctor;
		}
		return null;
	}*/

}
