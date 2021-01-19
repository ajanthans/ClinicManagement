package com.nets.patientvisit.patientvisit.exception;

public class HolidayException  extends  RuntimeException{
    private String message;

    public HolidayException(String message) {
        super(message);
    }
}
