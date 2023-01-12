package com.hospital.administration_SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.administration_SpringBoot.DAO.AppointmentDAO;
import com.hospital.administration_SpringBoot.models.Appointment;
import com.hospital.administration_SpringBoot.models.Doctor;
import com.hospital.administration_SpringBoot.models.Patient;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentDAO appointmentDAO;

	@Override
	public List<Appointment> getAppointments() {
		
		List<Appointment> CONSULTATIONS = (List<Appointment>) appointmentDAO.findAll();
		if(!CONSULTATIONS.isEmpty()) {
			return CONSULTATIONS;
		}
		else {
			return null;
		}
	}

	@Override
	public Appointment saveAppointment(Appointment appointment) {
		
		Appointment _appointment = new Appointment();
		
		_appointment.setId_appointment(appointment.getId_appointment());
		_appointment.setDateAppointment(appointment.getDateAppointment());
		_appointment.setPatient(appointment.getPatient());
		_appointment.setDoctor(appointment.getDoctor());
		
		appointmentDAO.save(_appointment);
		return _appointment;
		
//	 Appointment savedAppointment = appointmentDAO.save(new Appointment(appointment.getTitle(),appointment.getAuthor(),appointment.getPrice()));
//	 return savedAppointment;
		
	}

	@Override
	public Appointment getAppointmentByID(Long id) {
		
		Optional<Appointment> retrievedAppointment = appointmentDAO.findById(id);
		if(retrievedAppointment.isPresent()) {
			return retrievedAppointment.get();
		}
		else {
			return null;
		}
		
	}

	@Override
	public Appointment updateAppointment(Long id, Appointment appointment) {
		
		Optional<Appointment> retrievedAppointment = appointmentDAO.findById(id);
		
		Appointment _appointment = retrievedAppointment.get();
		
		_appointment.setId_appointment(appointment.getId_appointment());
		_appointment.setDateAppointment(appointment.getDateAppointment());
		_appointment.setPatient(appointment.getPatient());
		_appointment.setDoctor(appointment.getDoctor());
		
		appointmentDAO.save(_appointment);
		return _appointment;
	}

	@Override
	public void deleteAppointmentByID(Long id) {
		appointmentDAO.deleteById(id);
		
	}

	@Override
	public void deleteAppointments() {
		appointmentDAO.deleteAll();
	}

	@Override
	public List<Appointment> getAppointmentsByDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		List<Appointment> appointments = appointmentDAO.findByDoctor(doctor);
		if(!appointments.isEmpty()) {
			return appointments;
		}
		return null;
	}
	
	@Override
	public List<Appointment> getAppointmentsByPatient(Patient patient) {
		// TODO Auto-generated method stub
		List<Appointment> appointments = appointmentDAO.findByPatient(patient);
		if(!appointments.isEmpty()) {
			return appointments;
		}
		return null;
	}

}
