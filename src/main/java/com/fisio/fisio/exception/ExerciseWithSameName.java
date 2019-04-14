package com.fisio.fisio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ExerciseWithSameName extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1455760730133290503L;
	private static final String MSG_PERSONS_WITH_SAME_NAME = "O nome informado já está em uso.";

	
	public ExerciseWithSameName() {
		super(MSG_PERSONS_WITH_SAME_NAME);
	}
	
}
