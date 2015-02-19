package com.ubs.opsit.interviews.parser;

import com.ubs.opsit.interviews.entity.BerlinClockTime;
import com.ubs.opsit.interviews.validator.TimeValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class BerlinClockTimeParserTest {

    private TimeParser timeParser;

    private String input;
    private BerlinClockTime expected;

    public BerlinClockTimeParserTest(String input, BerlinClockTime expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"10:20:45", new BerlinClockTime(10, 20, 45)},
                {"10:20:40", new BerlinClockTime(10, 20, 40)},
                {"15:25:15", new BerlinClockTime(15, 25, 15)},
                {"00:40:05", new BerlinClockTime(00, 40, 05)},
                {"11:04:45", new BerlinClockTime(11, 04, 45)},
                {"07:40:00", new BerlinClockTime(07, 40, 00)}
        });
    }

    @Before
    public void before() {
        timeParser = new BerlinClockTimeParser(new TimeValidator());
    }

    @Test
    public void shouldReturnProperTimeEntity() {
        assertEquals(timeParser.parse(input), expected);
    }
}