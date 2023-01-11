package com.hospital.administration_SpringBoot.controller;

import java.util.List;

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

import com.hospital.administration_SpringBoot.models.Consultation;
import com.hospital.administration_SpringBoot.service.ConsultationService;

@RestController
@RequestMapping(path = "/api/consultation")
public class ConsultationController {
	
	@Autowired
	ConsultationService consultationService;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Consultation>> getConsultations(){
		try {
			List<Consultation> categories = consultationService.getConsultations();
			return new ResponseEntity<>(categories, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Consultation> saveConsultation(@RequestBody Consultation consultation){
		try {
			return new ResponseEntity<Consultation>(consultationService.saveConsultation(consultation), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "consultation/{id}")
	public ResponseEntity<Consultation> getConsultationByID(@PathVariable Long code){
		try {
			if(consultationService.getConsultationByID(code) != null) {
				return new ResponseEntity<Consultation>(consultationService.getConsultationByID(code), HttpStatus.OK);
			}
			return new ResponseEntity<Consultation>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "consultation/{id}")
	public void deleteConsultationByID(@PathVariable Long id) {
		consultationService.deleteConsultationByID(id);
	}

}
