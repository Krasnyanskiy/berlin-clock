package com.ubs.opsit.interviews.exceptions;

public class WrongTimeFormatException extends RuntimeException {

    private final static String MESSAGE = "You have specified the time in a wrong format.";

    public WrongTimeFormatException() {
        super(MESSAGE);
    }

    public WrongTimeFormatException(String msg) {
        super(msg);
    }
}
