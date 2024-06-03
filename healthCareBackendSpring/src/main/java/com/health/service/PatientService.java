package com.health.service;

import java.util.List;

import com.health.dto.ApiResponse;
import com.health.dto.PatientDTO;

public interface PatientService {
	ApiResponse registerPatient(PatientDTO dto);

	List<PatientDTO> getDetails();
}
