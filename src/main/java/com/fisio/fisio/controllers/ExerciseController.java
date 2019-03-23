package com.fisio.fisio.controllers;

import com.fisio.fisio.model.Exercise;
import com.fisio.fisio.repository.ExerciseJpaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

	@Autowired
	private ExerciseJpaRepository exerciseJpaRepository;

	@GetMapping(value = "/all")
	public List<Exercise> findAll() {
		return exerciseJpaRepository.findAll();
	}

	@GetMapping(value = "/{name}")
	public Exercise findByName(@PathVariable final String name) {
		return exerciseJpaRepository.findByName(name);
	}

	@PostMapping(value = "/insert")
	public Exercise insertExercise(@RequestBody final Exercise exercise) {
		exerciseJpaRepository.save(exercise);
		return exerciseJpaRepository.findByName(exercise.getName());
	}

	@PutMapping(value = "/{id}/update")
	public ResponseEntity<Object> updateExercise(@RequestBody final Exercise exercise, @PathVariable final Long id) {

		Optional<Exercise> exerciseUpdate = exerciseJpaRepository.findById(id);

		if (!exerciseUpdate.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		exercise.setId(id);
		exerciseJpaRepository.save(exercise);
		
		return ResponseEntity.notFound().build();

	}

}
