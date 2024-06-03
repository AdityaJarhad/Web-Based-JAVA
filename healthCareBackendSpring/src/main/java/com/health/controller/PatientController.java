package com.health.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.dto.ApiResponse;
import com.health.dto.PatientDTO;
import com.health.entity.PatientEntity;
import com.health.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	/*
	 For adding a new patient.
	 i/p - name , email , password
     URL - http://host:port/patient ,
     Method - POST
     payload - patient dto 
     resp - DTO (api resp : mesg)
	 */
	
	@PostMapping
	public ResponseEntity<ApiResponse> addPatient(@RequestBody PatientDTO dto){
		System.out.println("in add patient "+getClass());
		 patientService.registerPatient(dto);
		 return ResponseEntity.ok(new ApiResponse("ok"));
	}
	
	@GetMapping
	public List<PatientDTO> getPatient(){
		System.out.println("in get patient "+getClass());
		return patientService.getDetails();
	}
	
}
