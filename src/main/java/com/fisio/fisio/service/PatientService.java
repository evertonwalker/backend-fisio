package com.fisio.fisio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisio.fisio.exception.PatientNotFoundException;
import com.fisio.fisio.exception.PatientWithSameCpfException;
import com.fisio.fisio.model.Patient;
import com.fisio.fisio.repository.PatientJpaRepository;

@Service
public class PatientService {

	@Autowired
	private PatientJpaRepository patientRepository;

	public Patient create(Patient patient) {

		if (verifySameCpf(patient.getCpf())) {
			throw new PatientWithSameCpfException();
		}

		return patientRepository.save(patient);

	}

	public Patient update(Patient patient) {

		Patient patientFind = findByCpf(patient.getCpf());
			
		if(patientFind.getCpf() != patient.getCpf() && verifySameCpf(patient.getCpf())) {
			throw new PatientWithSameCpfException();
		} 

		patientFind.update(patient);

		return patientRepository.save(patientFind);

	}

	public Patient findByCpf(String cpf) {
		Optional<Patient> patient = patientRepository.findById(cpf);

		if (patient.isEmpty()) {
			throw new PatientNotFoundException();
		}
		return patient.get();

	}

	public List<Patient> findAllPatient() {
		return patientRepository.findAll();
	}

	public void delete(String cpf) {
		patientRepository.delete(findByCpf(cpf));
	}

	private Boolean verifySameCpf(String cpf) {
		return patientRepository.existsByCpf(cpf);
	}


}
