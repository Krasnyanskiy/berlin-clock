package com.ubs.opsit.interviews.exceptions;

public class WrongTimeFormatException extends RuntimeException {

    public WrongTimeFormatException() {
        super("You have specified the time in a wrong format.");
    }
}
