package com.fisio.fisio.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fisio.fisio.model.Patient;
import com.fisio.fisio.service.PatientService;



@RestController
@RequestMapping("api/patient")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	

	@GetMapping(value = "/")
	public List<Patient> findAll(){
		return patientService.findAllPatient();
	}
	
	@GetMapping(value = "/{cpf}")
	public Patient findByCpf(@PathVariable final String cpf) {
		return patientService.findByCpf(cpf);
	}
	
	@PostMapping(value = "/")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Patient insert(@RequestBody @Valid Patient patient) {
		return patientService.create(patient);
	}
	
	@PutMapping(value = "/{cpf}")
	@ResponseStatus(code = HttpStatus.OK)
	public Patient update(@PathVariable final String cpf, @RequestBody @Valid Patient patient) {
		return patientService.update(patient);
	}
	
	@DeleteMapping(value = "/{cpf}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable final String cpf) {
		patientService.delete(cpf);
	}
	
	
}
