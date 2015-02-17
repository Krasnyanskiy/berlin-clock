package com.ubs.opsit.interviews.fixtures;

import com.ubs.opsit.interviews.builder.BerlinClockBuilder;
import com.ubs.opsit.interviews.builder.ClockBuilder;
import com.ubs.opsit.interviews.entity.BerlinClockTime;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Before;
import org.junit.Test;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * @author Alexander Krasnyanskiy
 */
public class BerlinClockBuilderFixture {

    private BerlinClockTime theTime;
    private ClockBuilder builder;

    @Before
    public void before() throws Exception {
        builder = new BerlinClockBuilder();
    }

    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock-builder.story")
                .run();
    }

    @When("the time is $hours $minutes $seconds")
    public void whenTheTimeIs(int hours, int minutes, int seconds) {
        theTime = new BerlinClockTime(hours, minutes, seconds);
    }

    @Then("builder should build a berlin clock time representation which look like $")
    public void thenBuilderShouldBuildAClockTimeRepresentationWhichLookLike(String timeRepresentation) {

        assertSame(builder.hour(theTime.getHour()),     builder);
        assertSame(builder.minute(theTime.getMinute()), builder);
        assertSame(builder.second(theTime.getSecond()), builder);

        assertEquals(builder.clock(), timeRepresentation);
    }
}
