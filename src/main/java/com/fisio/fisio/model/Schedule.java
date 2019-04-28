package com.fisio.fisio.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Schedule")
@Table(name = "schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date startDate;

	private Date endDate;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "exercise_schedules", joinColumns = @JoinColumn(name = "exercises_id"), inverseJoinColumns = @JoinColumn(name = "schedules_id"))
	private List<Exercise> exercises = new ArrayList<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_cpf")
	private Patient patient;

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
		}
		return schedule;
	}

}
