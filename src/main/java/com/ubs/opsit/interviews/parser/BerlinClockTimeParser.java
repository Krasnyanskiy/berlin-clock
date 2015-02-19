package com.ubs.opsit.interviews.parser;

import com.ubs.opsit.interviews.entity.BerlinClockTime;
import com.ubs.opsit.interviews.validator.TimeValidator;

import static java.lang.Integer.parseInt;

public class BerlinClockTimeParser implements TimeParser {

    private TimeValidator timeValidator;

    public BerlinClockTimeParser(TimeValidator timeValidator) {
        this.timeValidator = timeValidator;
    }

    @Override
    public BerlinClockTime parse(String time) {

        timeValidator.validate(time);

        String[] timeParts = time.split(":");
        int hours = parseInt(timeParts[0]);
        int minutes = parseInt(timeParts[1]);
        int seconds = parseInt(timeParts[2]);

        return new BerlinClockTime(hours, minutes, seconds);
    }
}
