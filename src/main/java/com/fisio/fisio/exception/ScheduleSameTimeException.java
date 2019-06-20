package com.fisio.fisio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class ScheduleSameTimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1891539131677310488L;
	private static final String SCHEDULE_SAME_TIME = "Agendamento com  os períodos iguais, verifique os horários.";

	public ScheduleSameTimeException() {
		super(SCHEDULE_SAME_TIME);
	}

}
