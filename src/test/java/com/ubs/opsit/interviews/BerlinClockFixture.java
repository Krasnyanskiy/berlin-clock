package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.builder.BerlinClockBuilder;
import com.ubs.opsit.interviews.builder.ClockBuilder;
import com.ubs.opsit.interviews.parser.BerlinClockTimeParser;
import com.ubs.opsit.interviews.parser.TimeParser;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Before;
import org.junit.Test;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing stories.  You should not need to
 * edit this class to complete the exercise, this is your definition of done.
 */
public class BerlinClockFixture {

    private TimeConverter berlinClock;
    private String theTime;

    @Before
    public void setUp() throws Exception {
        TimeParser parser = new BerlinClockTimeParser();
        ClockBuilder builder = new BerlinClockBuilder();
        berlinClock = new BerlinClockTimeConverter(parser, builder);
    }

    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock-midnight-case.story")
                .withStory("berlin-clock.story")
                .run();
    }

    @When("the time is $time")
    public void whenTheTimeIs(String time) {
        theTime = time;
    }

    @Then("the clock should look like $")
    public void thenTheClockShouldLookLike(String theExpectedBerlinClockOutput) {
        assertThat(berlinClock.convertTime(theTime), is(equalTo(theExpectedBerlinClockOutput)));
    }
}
