package com.ubs.opsit.interviews.builder;

import static java.util.Arrays.fill;

public class BerlinClockBuilder implements ClockBuilder {

    private static final char OFF = 'O';
    private static final char RED = 'R';
    private static final char YELLOW = 'Y';
    private static final String CR = System.lineSeparator();

    private char[] secondsLamp = new char[1];
    private char[] fiveHoursRedLamps = new char[4];
    private char[] oneHourRedLamps = new char[4];
    private char[] fiveMinutesYellowRedLamps = new char[11];
    private char[] oneMinuteYellowLamps = new char[4];

    public BerlinClockBuilder() {
        turnClockOff();
    }

    @Override
    public ClockBuilder hour(int hours) {
        int fiveHoursCount = hours / 5;
        int oneHourCount = hours % 5;
        turnOnLampsRow(fiveHoursRedLamps, RED, fiveHoursCount);
        turnOnLampsRow(oneHourRedLamps, RED, oneHourCount);
        return this;
    }

    @Override
    public ClockBuilder minute(int minutes) {
        int fiveMinsCount = minutes / 5;
        int oneMinCount = minutes % 5;
        turnOnLampsRow(fiveMinutesYellowRedLamps, YELLOW, fiveMinsCount);
        paintQuoterLamps(fiveMinutesYellowRedLamps, YELLOW, RED);
        turnOnLampsRow(oneMinuteYellowLamps, YELLOW, oneMinCount);
        return this;
    }

    @Override
    public ClockBuilder second(int second) {
        boolean isSecondTick = second % 2 == 0;
        secondsLamp[0] = isSecondTick ? YELLOW : OFF;
        return this;
    }

    @Override
    public String clock() {
        return new StringBuilder()
                .append(secondsLamp).append(CR)
                .append(fiveHoursRedLamps).append(CR)
                .append(oneHourRedLamps).append(CR)
                .append(fiveMinutesYellowRedLamps).append(CR)
                .append(oneMinuteYellowLamps)
                .toString();
    }

    private void turnClockOff() {
        fill(secondsLamp, OFF);
        fill(fiveHoursRedLamps, OFF);
        fill(oneHourRedLamps, OFF);
        fill(fiveMinutesYellowRedLamps, OFF);
        fill(oneMinuteYellowLamps, OFF);
    }

    private void turnOnLampsRow(char[] lamps, char on, int onLampsCount) {
        for (int i = 0; i < onLampsCount; ++i) {
            lamps[i] = on;
        }
    }

    private char[] paintQuoterLamps(char[] lamps, char on, char specialColor) {
        int lampsCount = lamps.length;
        for (int i = 0; i < lampsCount; ++i) {
            boolean isQuoterLamp = (i + 1) % 3 == 0;
            boolean lampIsOn = lamps[i] == on;
            if (isQuoterLamp && lampIsOn) {
                lamps[i] = specialColor;
            }
        }
        return lamps;
    }
}
