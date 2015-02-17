package com.ubs.opsit.interviews.parser;

import com.ubs.opsit.interviews.entity.BerlinClockTime;

public interface TimeParser {
    BerlinClockTime parse(String time);
}