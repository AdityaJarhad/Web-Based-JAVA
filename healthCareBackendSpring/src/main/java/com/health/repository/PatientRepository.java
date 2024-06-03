package com.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.dto.PatientDTO;
import com.health.entity.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {


}
