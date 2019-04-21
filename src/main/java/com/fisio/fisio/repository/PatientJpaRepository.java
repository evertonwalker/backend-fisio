package com.fisio.fisio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.fisio.fisio.model.Patient;

@Component
public interface PatientJpaRepository extends JpaRepository<Patient, String> {
	
	Boolean existsByCpf(String cpf);
}
