package com.ubs.opsit.interviews.parser;

import com.ubs.opsit.interviews.entity.BerlinClockTime;
import com.ubs.opsit.interviews.exceptions.WrongTimeFormatException;

import static java.lang.Integer.parseInt;

public class BerlinClockTimeParser implements TimeParser {

    @Override
    public BerlinClockTime parse(String time) {

        int hours;
        int minutes;
        int seconds;

        String[] timeParts = time.split(":");
        if (timeParts.length == 0 || timeParts.length > 3) {
            throw new WrongTimeFormatException();
        }
        if (!isNumeric(timeParts[0]) || !isNumeric(timeParts[1]) || !isNumeric(timeParts[2])) {
            throw new WrongTimeFormatException();
        }
        hours = parseInt(timeParts[0]);
        minutes = parseInt(timeParts[1]);
        seconds = parseInt(timeParts[2]);
        if (hours > 24 || minutes > 59 || seconds > 59) {
            throw new WrongTimeFormatException();
        }
        if (hours == 24 && (minutes > 0 || seconds > 0)) {
            throw new WrongTimeFormatException();
        }
        return new BerlinClockTime(hours, minutes, seconds);
    }

    private boolean isNumeric(String n) {
        return n.matches("\\d+");
    }
}
