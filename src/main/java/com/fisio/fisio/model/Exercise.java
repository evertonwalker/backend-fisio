package com.fisio.fisio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity(name = "Exercise")
@Table(name = "exercise")
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@NotBlank(message = "O exercício deve possuir um nome.")
	String name;

	String description;

	@ManyToMany(mappedBy = "exercises", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	
	List<Schedule> schedules = new ArrayList<>();

	Exercise() {

	}

	Exercise(String name, String description) {
		this.name = name;
		this.description = description;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void update(Exercise exercise) {
		if (exercise != null) {
			this.name = exercise.getName();
			this.description = exercise.getDescription();
		}
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

}
