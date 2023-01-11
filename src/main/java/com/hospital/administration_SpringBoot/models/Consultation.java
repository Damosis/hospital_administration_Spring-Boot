package com.hospital.administration_SpringBoot.models;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultation")
public class Consultation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_consultation;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Timestamp dateConsultation;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_id_patient", referencedColumnName = "id_patient")
    private Patient patient;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_id_doctor", referencedColumnName = "id_doctor")
    private Doctor doctor;
	
	// Constructeur

	public Consultation(Timestamp dateConsultation, Doctor doctor, Patient patient) {
			
		this.dateConsultation=dateConsultation;
		this.doctor=doctor;
		this.patient=patient;
	}

	public Consultation() {
		// TODO Auto-generated constructor stub
	}

	public Long getId_consultation() {
		return id_consultation;
	}

	public void setId_consultation(Long id_consultation) {
		this.id_consultation = id_consultation;
	}

	public Timestamp getDateConsultation() {
		return dateConsultation;
	}

	public void setDateConsultation(Timestamp dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
