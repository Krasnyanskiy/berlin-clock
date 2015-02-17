package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.builder.ClockBuilder;
import com.ubs.opsit.interviews.entity.BerlinClockTime;
import com.ubs.opsit.interviews.parser.TimeParser;

/**
 * An implementation of {@link TimeConverter} class.
 */
public class BerlinClockTimeConverter implements TimeConverter {

    private TimeParser timeParser;
    private ClockBuilder clockBuilder;

    public BerlinClockTimeConverter(TimeParser timeParser, ClockBuilder clockBuilder) {
        this.timeParser = timeParser;
        this.clockBuilder = clockBuilder;
    }

    @Override
    public String convertTime(String aTime) {
        BerlinClockTime now = timeParser.parse(aTime);
        return clockBuilder
                .hour(now.getHour())
                .minute(now.getMinute())
                .second(now.getSecond())
                .clock();
    }
}
