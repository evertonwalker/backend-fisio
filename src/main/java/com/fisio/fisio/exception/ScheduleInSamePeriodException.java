package com.fisio.fisio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ScheduleInSamePeriodException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2560428291649438092L;
	public static final String SAME_PERIOD_SCHEDULE = "Existe um agendamento no mesmo horário.";
	
	public ScheduleInSamePeriodException() {
		super(SAME_PERIOD_SCHEDULE);
	}
	
	
}
