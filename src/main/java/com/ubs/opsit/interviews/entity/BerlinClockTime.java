package com.ubs.opsit.interviews.entity;

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

    @Override
    public String toString() {
        return "BerlinClockTime{" +
                "minutes=" + minutes +
                ", seconds=" + seconds +
                ", hours=" + hours +
                '}';
    }
}
