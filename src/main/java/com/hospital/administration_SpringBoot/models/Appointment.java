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
@Table(name = "appointment")
public class Appointment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_appointment;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Timestamp dateAppointment;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_id_patient", referencedColumnName = "id_patient")
    private Patient patient;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_id_doctor", referencedColumnName = "id_doctor")
    private Doctor doctor;
	
	// Constructeur

	public Appointment(Timestamp dateAppointment, Doctor doctor, Patient patient) {
			
		this.dateAppointment=dateAppointment;
		this.doctor=doctor;
		this.patient=patient;
	}

	public Appointment() {
		// TODO Auto-generated constructor stub
	}

	public Long getId_appointment() {
		return id_appointment;
	}

	public void setId_appointment(Long id_appointment) {
		this.id_appointment = id_appointment;
	}

	public Timestamp getDateAppointment() {
		return dateAppointment;
	}

	public void setDateAppointment(Timestamp dateAppointment) {
		this.dateAppointment = dateAppointment;
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
