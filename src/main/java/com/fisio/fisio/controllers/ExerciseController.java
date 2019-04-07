package com.fisio.fisio.controllers;

import com.fisio.fisio.model.Exercise;
import com.fisio.fisio.repository.ExerciseJpaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/exercise")
public class ExerciseController {

	@Autowired
	private ExerciseJpaRepository exerciseJpaRepository;

	@GetMapping(value = "/all")
	public List<Exercise> findAll() {
		return exerciseJpaRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Exercise findByName(@PathVariable final Long id) {
		Optional<Exercise> exerciseFind = exerciseJpaRepository.findById(id);
		return exerciseFind.orElse(null);

	}

	@PostMapping(value = "/insert")
	public ResponseEntity<String> insertExercise(@RequestBody final Exercise exercise) {
		exerciseJpaRepository.save(exercise);
		Exercise exerciseSuccess = exerciseJpaRepository.findByName(exercise.getName());
		if(exerciseSuccess != null) {
			return new ResponseEntity<>("Exercício inserido com sucesso.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Falha ao inserir", HttpStatus.BAD_REQUEST);
		}
		
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

	@DeleteMapping(value = "/{id}/delete")
	public ResponseEntity<Object> deleteExercise(@PathVariable final Long id) {

		Optional<Exercise> exerciseDelete = exerciseJpaRepository.findById(id);
		if (!exerciseDelete.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		exerciseJpaRepository.deleteById(exerciseDelete.get().getId());

		return ResponseEntity.status(HttpStatus.OK).body(null);

	}

}
