package com.ubs.opsit.interviews.validator;

import com.ubs.opsit.interviews.exceptions.NotNumericTimeFormatException;
import com.ubs.opsit.interviews.exceptions.NullTimeException;
import com.ubs.opsit.interviews.exceptions.WrongTimeFormatException;
import com.ubs.opsit.interviews.exceptions.WrongTimeRangeException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeValidatorTest {

    private TimeValidator timeValidator;

    @Before
    public void before() {
        timeValidator = new TimeValidator();
    }

    @Test
    public void shouldThrowExceptionWithProperMessage() {
        try {
            timeValidator.validate("wrongData");
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(WrongTimeFormatException.class)
                    .hasMessage("You have specified the time in a wrong format.");
        }
    }

    @Test
    public void shouldThrowWrongTimeRangeExceptionWithProperMessage() {
        try {
            timeValidator.validate("10:200:30");
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(WrongTimeRangeException.class)
                    .hasMessage("The time range should be like this: " +
                            "hour {0 - 24}, " +
                            "minutes {0 - 60}, " +
                            "seconds {0 - 60})");
        }
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