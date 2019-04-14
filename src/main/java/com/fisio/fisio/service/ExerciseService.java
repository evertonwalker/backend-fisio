package com.fisio.fisio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisio.fisio.exception.ExerciseNotFoundException;
import com.fisio.fisio.exception.ExerciseWithSameName;
import com.fisio.fisio.model.Exercise;
import com.fisio.fisio.repository.ExerciseJpaRepository;

@Service
public class ExerciseService {

	@Autowired
	private ExerciseJpaRepository exerciseJpaRepository;

	public Exercise create(Exercise exercise) {

		if (this.existsExerciseSameName(exercise.getName())) {
			throw new ExerciseWithSameName();
		}

		return exerciseJpaRepository.save(exercise);

	}

	public Exercise update(Long id, Exercise exercise) {

		Optional<Exercise> exerciseUpdate = exerciseJpaRepository.findById(id);

		if (this.existsExerciseSameName(exercise.getName())) {
			throw new ExerciseWithSameName();
		}
		
		exerciseUpdate.get().update(exercise);

		return exerciseJpaRepository.save(exerciseUpdate.get());

	}

	private Boolean existsExerciseSameName(String name) {
		return this.exerciseJpaRepository.existsByName(name);
	}

	public Exercise find(Long id) {
		Optional<Exercise> exerciseFind = exerciseJpaRepository.findById(id);
		return exerciseFind.orElseThrow(() -> new ExerciseNotFoundException());
	}

	public void delete(Long id) {
		this.exerciseJpaRepository.delete(this.find(id));
	}

	public List<Exercise> findAll() {
		return exerciseJpaRepository.findAll();
	}

}
