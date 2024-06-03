package com.health.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.health.dto.ApiResponse;
import com.health.dto.PatientDTO;
import com.health.entity.PatientEntity;
import com.health.repository.PatientRepository;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse registerPatient(PatientDTO dto) {
		System.out.println("in register patient " + getClass());
		PatientEntity map = mapper.map(dto, PatientEntity.class);
		patientRepository.save(map);
		return new ApiResponse("Added success");
	}

	@Override
	public List<PatientDTO> getDetails() {
		System.out.println("in getAllDetails " + getClass());
		List<PatientDTO> list = patientRepository.findAll()
		.stream()
		.map( l -> 
		mapper.map(l, PatientDTO.class)) //stream<DTO>
		.collect(Collectors.toList());
		return list;
	}

}
