package com.fisio.fisio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Patient {
	
	@Id
	private String cpf;
	
	@Column(unique=false)
	@NotBlank(message = "O paciente deve possuir um nome.")
	private String fullName;
	
	@NotBlank(message = "O paciente deve possuir a data de nascimento.")
	private Date birthOfDate;
	
	@NotBlank(message = "O paciente deve possuir um e-mail para contato.")
	private String email;
	
	@NotBlank(message = "O paciente deve possuir um telefone para contato.")
	private String cellPhone;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthOfDate() {
		return birthOfDate;
	}

	public void setBirthOfDate(Date birthOfDate) {
		this.birthOfDate = birthOfDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	public void update(Patient patient) {
		if(patient != null) {
			this.cpf = patient.getCpf();
			this.fullName = patient.getFullName();
			this.birthOfDate = patient.getBirthOfDate();
			this.email = patient.getEmail();
			this.cellPhone = patient.getCellPhone();
		}
	}
	
	
}
