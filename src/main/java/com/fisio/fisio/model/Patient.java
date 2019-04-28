package com.fisio.fisio.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="Patient")
@Table(name="patient")
public class Patient {

	@Id
	@CPF(message = "O Formato do cpf não está correto.")
	private String cpf;

	@Column(unique = false)
	@NotBlank(message = "O paciente deve possuir um nome.")
	private String fullName;

	private Date birthOfDate;

	@Email(message = "O formato do e-mail não está correto")
	@NotBlank(message = "O paciente deve possuir um e-mail para contato.")
	private String email;

	@NotBlank(message = "O paciente deve possuir um telefone para contato.")
	private String cellPhone;

	@OneToMany(mappedBy="patient", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	List<Schedule> schedules;

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

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public void update(Patient patient) {
		if (patient != null) {
			this.cpf = patient.getCpf();
			this.fullName = patient.getFullName();
			this.birthOfDate = patient.getBirthOfDate();
			this.email = patient.getEmail();
			this.cellPhone = patient.getCellPhone();
		}
	}

}
