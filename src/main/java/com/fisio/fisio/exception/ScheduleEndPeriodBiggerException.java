package com.fisio.fisio.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class ScheduleEndPeriodBiggerException extends RuntimeException {

    private static final long serialVersionUID = -2560428291649438092L;
    private static final String PERIOD_BIGGER_THAN_INIT = "A data final não pode ser menor que a primeira";

   public ScheduleEndPeriodBiggerException(){
        super(PERIOD_BIGGER_THAN_INIT);
    }
}
