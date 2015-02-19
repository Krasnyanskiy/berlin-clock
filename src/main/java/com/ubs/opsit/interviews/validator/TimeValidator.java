package com.ubs.opsit.interviews.validator;

import com.ubs.opsit.interviews.exceptions.NotNumericTimeFormatException;
import com.ubs.opsit.interviews.exceptions.NullTimeException;
import com.ubs.opsit.interviews.exceptions.WrongTimeFormatException;
import com.ubs.opsit.interviews.exceptions.WrongTimeRangeException;

import static java.lang.Integer.parseInt;

public class TimeValidator {

    public void validate(String time) {
        if (time == null) {
            throw new NullTimeException();
        }
        String[] timeParts = time.split(":");
        if (timeParts.length != 3) {
            throw new WrongTimeFormatException();
        }
        if (!isNumeric(timeParts[0]) || !isNumeric(timeParts[1])
                || !isNumeric(timeParts[2])) {
            throw new NotNumericTimeFormatException();
        }
        int hours = parseInt(timeParts[0]);
        int minutes = parseInt(timeParts[1]);
        int seconds = parseInt(timeParts[2]);
        if (hours > 24 || minutes > 59 || seconds > 59) {
            throw new WrongTimeRangeException();
        }
        if (hours == 24 && (minutes > 0 || seconds > 0)) {
            throw new WrongTimeRangeException();
        }
    }

    private boolean isNumeric(String n) {
        return n.matches("\\d+");
    }
}
