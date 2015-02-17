package com.ubs.opsit.interviews.builder;

public interface ClockBuilder {
    ClockBuilder second(int seconds);
    ClockBuilder hour(int hours);
    ClockBuilder minute(int minutes);
    String clock();
}