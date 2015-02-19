package com.ubs.opsit.interviews.validator;

import com.ubs.opsit.interviews.exceptions.NotNumericTimeFormatException;
import com.ubs.opsit.interviews.exceptions.NullTimeException;
import com.ubs.opsit.interviews.exceptions.WrongTimeFormatException;
import com.ubs.opsit.interviews.exceptions.WrongTimeRangeException;
import org.junit.Before;
import org.junit.Test;

public class TimeValidatorTest {

    private TimeValidator timeValidator;

    @Before
    public void before() {
        timeValidator = new TimeValidator();
    }

    @Test(expected = NullTimeException.class)
    public void shouldThrowExceptionWhenPassTheNullTimeInstance() {
        timeValidator.validate(null);
    }

    @Test(expected = WrongTimeFormatException.class)
    public void shouldThrowExceptionWhenPassWrongTimeData() {
        timeValidator.validate("blablabla");
    }

    @Test(expected = WrongTimeFormatException.class)
    public void shouldThrowExceptionWhenPassTimeInNotProperFormat() {
        timeValidator.validate("100500");
    }

    @Test(expected = NotNumericTimeFormatException.class)
    public void shouldThrowExceptionWhenPassTimeInNotNumericFormat() {
        timeValidator.validate("ab:cd:ef");
    }

    @Test(expected = WrongTimeRangeException.class)
    public void shouldThrowExceptionWhenPassTimeWithWrongMinutesRage() {
        timeValidator.validate("10:200:30");
    }

    @Test(expected = WrongTimeRangeException.class)
    public void shouldThrowExceptionWhenPassTimeWithWrongSecondsRage() {
        timeValidator.validate("10:20:300");
    }

    @Test(expected = WrongTimeRangeException.class)
    public void shouldThrowExceptionWhenPassTimeWithWrongHoursRage() {
        timeValidator.validate("100:20:30");
    }

    @Test(expected = WrongTimeRangeException.class)
    public void shouldThrowExceptionWhenPassTimeWithWrongMinutesAndHoursRage() {
        timeValidator.validate("100:200:30");
    }
}