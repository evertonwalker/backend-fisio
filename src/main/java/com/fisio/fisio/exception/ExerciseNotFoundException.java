package com.fisio.fisio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExerciseNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String NOT_FOUND_MSG = "O exercício procurado não existe.";

	public ExerciseNotFoundException() {
		super(NOT_FOUND_MSG);
	}

}
