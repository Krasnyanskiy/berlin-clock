package com.ubs.opsit.interviews.builder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BerlinClockBuilderTest {

    private ClockBuilder builder;
    private static final String NOON = "Y\nRROO\nRROO\nOOOOOOOOOOO\nOOOO";
    private static final String MIDNIGHT_V1 = "Y\nRRRR\nRRRR\nOOOOOOOOOOO\nOOOO";
    private static final String MIDNIGHT_V2 = "Y\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO";
    private static final String JEWISH_TIME = "Y\nROOO\nRROO\nYYRYYRYYOOO\nOOOO";


    @Before
    public void before() {
        builder = new BerlinClockBuilder();
    }

    @Test
    public void shouldReturnTheSameBuilderInstance() {
        ClockBuilder retrieved = builder.hour(24).minute(15).second(10);
        Assert.assertEquals(retrieved, builder);
    }

    @Test
    public void shouldBuildMidnightBerlinTimeRepresentation() {
        ClockBuilder retrieved = builder.hour(24).minute(00).second(00);
        String retrievedTimeRepresentation = retrieved.clock();
        Assert.assertEquals(retrievedTimeRepresentation, MIDNIGHT_V1);
    }

    @Test
    public void shouldBuildRareStyleMidnightBerlinTimeRepresentation() {
        ClockBuilder retrieved = builder.hour(00).minute(00).second(00);
        String retrievedTimeRepresentation = retrieved.clock();
        Assert.assertEquals(retrievedTimeRepresentation, MIDNIGHT_V2);
    }

    @Test
    public void shouldBuildNoonBerlinTimeRepresentation() {
        ClockBuilder retrieved = builder.hour(12).minute(00).second(00);
        String retrievedTimeRepresentation = retrieved.clock();
        Assert.assertEquals(retrievedTimeRepresentation, NOON);
    }

    @Test
    public void shouldBuild_7_40_BerlinTimeRepresentation() {
        ClockBuilder retrieved = builder.hour(07).minute(40).second(00);
        String retrievedTimeRepresentation = retrieved.clock();
        Assert.assertEquals(retrievedTimeRepresentation, JEWISH_TIME);
    }
}