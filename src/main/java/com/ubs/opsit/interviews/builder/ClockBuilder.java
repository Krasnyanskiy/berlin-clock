package com.ubs.opsit.interviews.builder;

/**
 * Clock Builder interface is used for building time
 * representation.
 */
public interface ClockBuilder {

    /**
     * Sets the representation state of Berlin Clock's top lamp.
     * If secondsCount is odd then we set the state of the lamp
     * to 'ON' (yellow color), otherwise to 'OFF'.
     *
     * @param seconds secondsCount
     * @return builder instance
     */
    ClockBuilder second(int seconds);

    /**
     * Sets the representation state of Berlin Clock's hour lamps.
     *
     * @param hours hoursCount
     * @return builder instance
     */
    ClockBuilder hour(int hours);

    /**
     * Sets the representation state of Berlin Clock's minute lamps.
     *
     * @param minutes minutesCount
     * @return builder instance
     */
    ClockBuilder minute(int minutes);

    /**
     * @return Berlin Clock time representation.
     */
    String clock();

}