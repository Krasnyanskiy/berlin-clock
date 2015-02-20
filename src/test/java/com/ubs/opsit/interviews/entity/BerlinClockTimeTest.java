package com.ubs.opsit.interviews.entity;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinClockTimeTest {

    @Test
    public void shouldCompareTwoDifferentTimeEntities() {
        BerlinClockTime firstTime = new BerlinClockTime(10, 55, 45);
        BerlinClockTime secondTime = new BerlinClockTime(10, 55, 45);

        assertThat(firstTime)
                .isNotNull()
                .isEqualTo(secondTime)
                .isEqualToComparingFieldByField(secondTime);
    }

    @Test
    public void shouldCompareTwoEqualTimeEntities() {
        BerlinClockTime firstTime = new BerlinClockTime(10, 55, 45);
        BerlinClockTime secondTime = new BerlinClockTime(12, 15, 20);

        assertThat(firstTime)
                .isNotNull()
                .isNotEqualTo(secondTime);
    }

    @Test
    public void shouldCompareTwoTimeEntitiesByHours() {
        BerlinClockTime firstTime = new BerlinClockTime(12, 10, 15);
        BerlinClockTime secondTime = new BerlinClockTime(12, 20, 20);

        assertThat(firstTime)
                .isNotNull()
                .isEqualToComparingOnlyGivenFields(secondTime, "hour");
    }

    @Test
    public void shouldCompareTwoTimeEntitiesByHoursAndMinutes() {
        BerlinClockTime firstTime = new BerlinClockTime(12, 10, 15);
        BerlinClockTime secondTime = new BerlinClockTime(12, 10, 20);

        assertThat(firstTime)
                .isNotNull()
                .isEqualToComparingOnlyGivenFields(secondTime, "hour", "minute");
    }

    @Test
    public void shouldReturnTheSameHashCodeForEqualTimeEntities() {
        BerlinClockTime firstTime = new BerlinClockTime(12, 10, 15);
        BerlinClockTime secondTime = new BerlinClockTime(12, 10, 15);

        assertThat(firstTime.hashCode())
                .isEqualTo(secondTime.hashCode());
    }

    @Test
    public void shouldReturnTheDifferentHashCodeForTwoDifferentTimeEntities() {
        BerlinClockTime firstTime = new BerlinClockTime(12, 20, 10);
        BerlinClockTime secondTime = new BerlinClockTime(22, 40, 55);

        assertThat(firstTime.hashCode())
                .isNotEqualTo(secondTime.hashCode());
    }
}