package com.ubs.opsit.interviews.entity;

/**
 * Berlin Clock Time entity. Stores the data of time units.
 */
public class BerlinClockTime {

    private int minutes;
    private int seconds;
    private int hours;

    public BerlinClockTime(int hours, int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.hours = hours;
    }

    public int getMinute() {
        return minutes;
    }

    public int getSecond() {
        return seconds;
    }

    public int getHour() {
        return hours;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BerlinClockTime that = (BerlinClockTime) o;

        if (hours != that.hours) return false;
        if (minutes != that.minutes) return false;
        if (seconds != that.seconds) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = minutes;
        result = 31 * result + seconds;
        result = 31 * result + hours;
        return result;
    }
}
