package com.hospital.administration_SpringBoot.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hospital.administration_SpringBoot.models.Doctor;
import com.hospital.administration_SpringBoot.service.DoctorService;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class DoctorControllerTest {

	@InjectMocks
	private DoctorController doctorController;
	
	@Mock
	private DoctorService doctorService;

	@Test
	public void getDoctors_withoutException() {
		
		//Given
		
		List<Doctor> list = new ArrayList<>();
		
		Doctor firstDoctor  = new Doctor();
		Doctor secondDoctor = new Doctor();
		
		list.add(secondDoctor);
		list.add(firstDoctor);
		
		//When
		Mockito.when(doctorService.getDoctors()).thenReturn(list);
		ResponseEntity<List<Doctor>> resultat = doctorController.getDoctors();
		
		//Then
		
		assertEquals(2, resultat.getBody().size());
		assertEquals(HttpStatus.OK, resultat.getStatusCode());
		
	}
	
	@Test
	public void getDoctorbyID() throws Exception {
		
		//given
		Doctor doctor = new Doctor();
		
		doctor.setId_doctor(2L);
		
		//when
		
		Mockito.when(doctorService.getDoctorByID(2L)).thenReturn(doctor);
		ResponseEntity<Doctor> response =  doctorController.getDoctorByID(2L);
		
		//Then
		assertEquals(HttpStatus.OK, response.getStatusCode());	
	}
	
	
	@Test
	public void createDoctor_WhitoutException() throws Exception {
		
		//given
		Doctor doctor = new Doctor();
		doctor.setId_doctor(3L);
		doctor.setFirstname("We love code");
		doctor.setLastname("Gilles H");
		
		//When
		Mockito.when(doctorService.saveDoctor(doctor)).thenReturn(doctor);
		ResponseEntity<Doctor> response = doctorController.saveDoctor(doctor);
		
		//Then
		assertThat(response.getBody().getId_doctor()).isGreaterThan(0);
		
	}
	
	@Test
	public void deleteDoctorByID() throws Exception {
		
		//given 
		Doctor doctor = new Doctor();
		doctor.setId_doctor(3L);
		doctor.setFirstname("We love code");
		doctor.setLastname("Gilles H");
		
		//When
		doctorController.deleteDoctorByID(30L);
		ResponseEntity<Doctor> retrievedDoctor = doctorController.getDoctorByID(doctor.getId_doctor());
		
		//Then
		assertThat(retrievedDoctor.getBody()).isNull();
	}
	
	@Test
	public void deleteDoctors() throws Exception {
		
		Doctor doctor = new Doctor();
		doctor.setId_doctor(3L);
		doctor.setFirstname("We love France");
		doctor.setLastname("Gilles H");
		
		doctorController.deleteDoctors();
		ResponseEntity<Doctor> retrievedDoctor = doctorController.getDoctorByID(doctor.getId_doctor());
		
		//Then
		assertThat(retrievedDoctor.getBody()).isNull();
		
		
	}
}

