package com.fisio.fisio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.fisio.fisio.model.Exercise;

@Component
public interface ExerciseJpaRepository extends JpaRepository<Exercise, Long> {

	Exercise findByName(String name);

}
