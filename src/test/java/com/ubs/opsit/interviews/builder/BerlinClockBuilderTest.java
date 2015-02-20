package com.ubs.opsit.interviews.builder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(builder.hour(24))
                .isEqualTo(builder.minute(15))
                .isEqualTo(builder.second(10))
                .isSameAs(builder);
    }

    @Test
    public void shouldBuildMidnightBerlinTimeRepresentation() {

        assertThat(builder.hour(24))
                .isEqualTo(builder.minute(00))
                .isEqualTo(builder.second(00));

        assertThat(builder.clock())
                .isNotEmpty()
                .isNotNull()
                .isEqualTo(MIDNIGHT_V1);
    }

    @Test
    public void shouldBuildRareStyleMidnightBerlinTimeRepresentation() {

        assertThat(builder.hour(00))
                .isEqualTo(builder.minute(00))
                .isEqualTo(builder.second(00));

        assertThat(builder.clock())
                .isNotEmpty()
                .isNotNull()
                .isEqualTo(MIDNIGHT_V2);
    }

    @Test
    public void shouldBuildNoonBerlinTimeRepresentation() {

        assertThat(builder.hour(12))
                .isEqualTo(builder.minute(00))
                .isEqualTo(builder.second(00));

        assertThat(builder.clock())
                .isNotEmpty()
                .isNotNull()
                .isEqualTo(NOON);
    }

    @Test
    public void shouldBuild_7_40_BerlinTimeRepresentation() {

        assertThat(builder.hour(07))
                .isEqualTo(builder.minute(40))
                .isEqualTo(builder.second(00));

        assertThat(builder.clock())
                .isNotEmpty()
                .isNotNull()
                .isEqualTo(JEWISH_TIME);
    }

    @Test
    public void shouldReturnTheSameHashCodeForEqualTimeBuilderEntities() {
        ClockBuilder firstBuilder = new BerlinClockBuilder();
        ClockBuilder secondBuilder = new BerlinClockBuilder();

        assertThat(firstBuilder.hashCode())
                .isEqualTo(secondBuilder.hashCode());
    }

    @Test
    public void shouldCompareTwoEqualTimeBuilderObjects() {
        ClockBuilder firstBuilder = new BerlinClockBuilder();
        ClockBuilder secondBuilder = new BerlinClockBuilder();

        assertThat(firstBuilder.equals(secondBuilder))
                .isTrue();
    }

    @After
    public void after() {
        builder = null;
    }
}