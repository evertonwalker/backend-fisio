package com.fisio.fisio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class PatientWithSameCpfException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5326906106542649132L;
	private static final String MSG_WITH_SAME_CPF = "Já existe um paciente com esse cpf.";
	
	
	public PatientWithSameCpfException() {
		super(MSG_WITH_SAME_CPF);
	}
	
}
