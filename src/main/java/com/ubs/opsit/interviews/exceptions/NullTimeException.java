package com.ubs.opsit.interviews.exceptions;

public class NullTimeException extends WrongTimeFormatException {

    public NullTimeException() {
        super("Time cannot be null.");
    }
}
