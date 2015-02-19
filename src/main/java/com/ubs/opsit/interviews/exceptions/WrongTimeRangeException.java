package com.ubs.opsit.interviews.exceptions;

public class WrongTimeRangeException extends WrongTimeFormatException {

    private final static String MESSAGE = "The time range should be like this: " +
            "hour {0 - 24}, " +
            "minutes {0 - 60}, " +
            "seconds {0 - 60})";

    public WrongTimeRangeException() {
        super(MESSAGE);
    }
}
