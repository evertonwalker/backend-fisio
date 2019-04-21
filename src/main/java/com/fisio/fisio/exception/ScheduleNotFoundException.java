package com.fisio.fisio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ScheduleNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4090353317464105487L;
	public static final String NOT_FOUND = "Agendamento não encontrado";
	
	public ScheduleNotFoundException() {
		super(NOT_FOUND);
	}
}
