package com.hospital.administration_SpringBoot.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.administration_SpringBoot.models.Appointment;
import com.hospital.administration_SpringBoot.service.AppointmentService;

@RestController
@RequestMapping(path = "/hospital/appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@GetMapping(path = "/")
	public ResponseEntity<Collection<Appointment>> getAppointments(){
		try {
			Collection<Appointment> appointments = appointmentService.getAppointments();
			return new ResponseEntity<>(appointments, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment){
		try {
			return new ResponseEntity<Appointment>(appointmentService.saveAppointment(appointment), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "appointment/{id}")
	public ResponseEntity<Appointment> getAppointmentByID(@PathVariable Long code){
		try {
			if(appointmentService.getAppointmentByID(code) != null) {
				return new ResponseEntity<Appointment>(appointmentService.getAppointmentByID(code), HttpStatus.OK);
			}
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "appointment/{id}")
	public void deleteAppointmentByID(@PathVariable Long id) {
		appointmentService.deleteAppointmentByID(id);
	}

}
