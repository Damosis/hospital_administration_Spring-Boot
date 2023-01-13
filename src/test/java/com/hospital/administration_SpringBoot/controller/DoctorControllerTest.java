package com.hospital.administration_SpringBoot.controller;

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
}

