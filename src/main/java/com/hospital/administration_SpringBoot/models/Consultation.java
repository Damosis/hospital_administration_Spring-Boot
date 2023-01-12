package com.hospital.administration_SpringBoot.models;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
	@Column(name = "price")
	private Float price;
	@Column(name = "report")
	private String report;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_id_appointment", referencedColumnName = "id_appointment")
    private Appointment appointment;
	
	// Constructeur

	public Consultation(Float price, String report, Appointment appointment) {
		this.price=price;
		this.report=report;
		this.appointment=appointment;
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}