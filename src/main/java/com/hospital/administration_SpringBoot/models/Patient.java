package com.hospital.administration_SpringBoot.models;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "patient")
public class Patient implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_patient;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
	private Collection<Consultation> consultations;
	
	// Constructeur

	public Patient(String firstname, String lastname) {
		this.firstname=firstname;
		this.lastname=lastname;
	}

	public Patient() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId_patient() {
		return id_patient;
	}
	public void setId_patient(Long id_patient) {
		this.id_patient = id_patient;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Collection<Consultation> getConsultations() {
		return consultations;
	}
	public void setConsultations(Collection<Consultation> consultations) {
		this.consultations = consultations;
	}
	
}