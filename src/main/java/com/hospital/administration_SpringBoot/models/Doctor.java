package com.hospital.administration_SpringBoot.models;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_doctor;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	
	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	private Collection<Consultation> consultations;
	
	// Constructeur

	public Doctor(String firstname, String lastname) {
		this.firstname=firstname;
		this.lastname=lastname;
	}

	public Doctor() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId_doctor() {
		return id_doctor;
	}
	public void setId_doctor(Long id_doctor) {
		this.id_doctor = id_doctor;
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