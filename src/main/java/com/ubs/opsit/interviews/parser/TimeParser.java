package com.ubs.opsit.interviews.parser;

import com.ubs.opsit.interviews.entity.BerlinClockTime;
import com.ubs.opsit.interviews.exceptions.WrongTimeFormatException;

public interface TimeParser {

    BerlinClockTime parse(String time) throws WrongTimeFormatException;
}