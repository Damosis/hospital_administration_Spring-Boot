package com.hospital.administration_SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.administration_SpringBoot.models.Appointment;
import com.hospital.administration_SpringBoot.models.Doctor;
import com.hospital.administration_SpringBoot.service.DoctorService;

@RestController
@RequestMapping(path = "/hospital/doctors")
public class DoctorController {

	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Doctor>>  getDoctors(){
		
		try {
			List<Doctor> doctors =  doctorService.getDoctors();
			return new ResponseEntity<>(doctors, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Doctor>  saveDoctor(@RequestBody Doctor doctor) {
		try {
			return new ResponseEntity<>(doctorService.saveDoctor(doctor), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Doctor> getDoctorByID(@PathVariable Long id) {
		try {
			Doctor _doctor = doctorService.getDoctorByID(id);
			if(_doctor != null) {
				return new ResponseEntity<>(_doctor, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(path = "/appointment/{id}")
	public ResponseEntity<Doctor> getDoctorsByAppointment(@RequestBody Appointment appointment){
		try {
			return new ResponseEntity<Doctor>(doctorService.getDoctorByAppointment(appointment),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Doctor>  updateDoctor(@PathVariable Long id,@RequestBody Doctor doctor) {
		try {
			return new ResponseEntity<Doctor>(doctorService.updateDoctor(id, doctor), HttpStatus.OK) ;
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping(path = "/{id}")
	 public void deleteDoctorByID(@PathVariable Long id) {
		  doctorService.deleteByID(id);
	 }
	 
	@DeleteMapping(path = "/")
	 public void deleteDoctors() {
		 doctorService.deleteDoctors();
	 }
}
