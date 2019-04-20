package com.fisio.fisio.controllers;

import com.fisio.fisio.model.Exercise;
import com.fisio.fisio.service.ExerciseService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/exercise")
public class ExerciseController {

	@Autowired()
	private ExerciseService exerciseService;
	
	@GetMapping(value = "/")
	public List<Exercise> findAll() {
		return exerciseService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Exercise findById(@PathVariable final Long id) {
		return exerciseService.find(id);

	}

	@PostMapping(value = "/")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Exercise insertExercise(@RequestBody @Valid final Exercise exercise) {
		return this.exerciseService.create(exercise);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Exercise updateExercise(@RequestBody final Exercise exercise, @PathVariable final Long id) {
		return this.exerciseService.update(id, exercise);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteExercise(@PathVariable final Long id) {
		this.exerciseService.delete(id);
	}

}
