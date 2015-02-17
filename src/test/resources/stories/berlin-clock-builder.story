Story: The Berlin Clock Builder

Meta:
@scope interview

Narrative:
    As a time builder guru
    I want to build the Berlin Clock Time using the Clock Builder
    So that I can ensure that my builder returns the corret time representation


Scenario: I pass the correct time data to parser
When the time is
10 40 45
Then builder should build a berlin clock time representation which look like
O
RROO
OOOO
YYRYYRYYOOO
OOOO