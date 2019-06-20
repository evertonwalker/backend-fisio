package com.fisio.fisio.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name = "Schedule")
@Table(name = "schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "O data inicial não pode está vazia.")
	private Date startDate;

	@NotNull(message = "O data final não pode está vazia.")
	private Date endDate;

	@NotEmpty(message = "É necessário selecionar os exercícios.")
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "exercise_schedules", joinColumns = @JoinColumn(name = "schedules_id"), inverseJoinColumns = @JoinColumn(name = "exercises_id"))
	private List<Exercise> exercises = new ArrayList<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_cpf")
	@NotNull(message = "É necessário selecionar um paciente.")
	private Patient patient;
	
	private String color;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Schedule update(Schedule schedule) {
		if (schedule != null) {
			this.startDate = schedule.getStartDate();
			this.endDate = schedule.getEndDate();
			this.patient = schedule.getPatient();
			this.exercises = schedule.getExercises();
			this.status = schedule.getStatus();
			this.color = schedule.getColor();
		}
		return schedule;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
