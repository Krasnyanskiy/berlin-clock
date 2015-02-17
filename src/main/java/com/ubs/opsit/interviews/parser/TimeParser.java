package com.ubs.opsit.interviews.parser;

import com.ubs.opsit.interviews.entity.BerlinClockTime;

/**
 * Time parser is used for parsing the passed time input, and
 * handling this input.
 */
public interface TimeParser {

    /**
     * Parses the time input, and extracts hours, minutes,
     * and seconds.
     *
     * @param time current time input
     * @return a time entity
     */
    BerlinClockTime parse(String time);
}