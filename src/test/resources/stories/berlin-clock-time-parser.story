Story: The Berlin Clock Parser

Meta:
@scope interview

Narrative:
    As a time parser ninja
    I want to parse the time using the Time Parser
    So that I can be sure that my parser works perfectly


Scenario: I pass the correct data to parser
When the given correct time is 10:40:45
Then the time entity should be equal to expected entity



Scenario: I pass to the parser the wrong data which
contains wrong time unit intervals
When the given wrong time is 99:99:99
Then the exception message should be like You have specified the time in a wrong format.



Scenario: I pass to the parser the wrong seconds
time unit inverval
When the given wrong time is 09:15:99
Then the exception message should be like You have specified the time in a wrong format.



Scenario: I pass to the parser the wrong
hour time unit interval
When the given wrong time is 24:99:00
Then the exception message should be like You have specified the time in a wrong format.



Scenario: I pass to the parser the wrong
time unit intervals
When the given wrong time is 25:61:30
Then the exception message should be like You have specified the time in a wrong format.



Scenario: I pass to parser the wrong data
which contains not numbers, but letters
When the given wrong time is AB:01:01
Then the exception message should be like You have specified the time in a wrong format.
