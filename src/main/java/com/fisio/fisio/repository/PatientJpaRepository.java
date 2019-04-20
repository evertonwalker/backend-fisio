package com.fisio.fisio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fisio.fisio.model.Patient;

public interface PatientJpaRepository extends JpaRepository<Patient, String> {
	
	Boolean existsByCpf(String cpf);
}
