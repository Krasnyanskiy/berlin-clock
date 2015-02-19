package com.ubs.opsit.interviews.exceptions;

public class NotNumericTimeFormatException extends WrongTimeFormatException {

    private final static String MESSAGE = "You should specify time in numeric format. " +
            "Example: 07:40:00";

    public NotNumericTimeFormatException() {
        super(MESSAGE);
    }



}
