package com.fisio.fisio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 503281305220436642L;
	public static final String NOT_FOUND = "Paciente procurado não existe.";
	
	public PatientNotFoundException () {
		super(NOT_FOUND);
	}
}
