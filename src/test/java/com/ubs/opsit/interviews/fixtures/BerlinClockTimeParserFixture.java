package com.ubs.opsit.interviews.fixtures;

import com.ubs.opsit.interviews.entity.BerlinClockTime;
import com.ubs.opsit.interviews.parser.BerlinClockTimeParser;
import com.ubs.opsit.interviews.parser.TimeParser;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Before;
import org.junit.Test;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.junit.Assert.assertEquals;

/**
* @author Alexander Krasnyanskiy
*/
public class BerlinClockTimeParserFixture {

    private BerlinClockTime timeEntity;
    private BerlinClockTime expectedEntity;
    private TimeParser parser;
    private Throwable exception;

    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock-time-parser.story")
                .run();
    }

    @Before
    public void before() throws Exception {
        parser = new BerlinClockTimeParser();
        expectedEntity = new BerlinClockTime(10, 40, 45);
    }

    @When("the given correct time is $time")
    public void whenTheGivenTimeIs(String time) {
         timeEntity = parser.parse(time);
    }

    @Then("the time entity should be equal to expected entity")
    public void thenTheTimeEntityShouldBeEqualToExpectedEntity() {
        assertEquals(expectedEntity, timeEntity);
    }

    @When("the given wrong time is $time")
    public void whenTheGivenWrongTimeIs(String time) {
        try {
            parser.parse(time);
        } catch (Throwable ex){
            exception = ex;
        }
    }

    @Then("the exception message should be like $")
    public void thenTheExceptionMessageShouldBeLike(String message){
        assertEquals(exception.getMessage(), message);
    }
}
