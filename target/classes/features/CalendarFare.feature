@Regression
Feature: Testing the Calendar Fare

  @Sanity
  Scenario: check the status code and schema
    Given call the calender fare api with origin "DXB" destination "LHR" adult 1
    Then verify the status code for calender fare
    And verify the response key with date range



  Scenario Outline: Check the mandatory element validation
    Given call the calendar fare api with "<origin>", "<destination>", "<from>", "<to>", "<cabin>", "<adtCount>", "<chdCount>", "<infCount>", "<airline>", "<type>"
    Then validate the error response code for mandatory element validation

    Examples:
      | origin | destination | from | to | cabin   | adtCount | chdCount | infCount | airline | type       |
      | DXB    | LHR         | 1    | 1  | Economy | 1        | 0        | 0        | O       | all        |
      | DXB    | LHR         | 1    | 1  | Economy | 1        | 0        | 0        | 0       | noAirports |
      | DXB    | LHR         | 1    | 1  | Economy | 1        | 0        | 0        | 0       | noOption   |
      |        | LHR         | 1    | 1  | Economy | 1        | 0        | 0        | 0       | all        |
      | DXB    |             | 1    | 1  | Economy | 1        | 0        | 0        | 0       | all        |
      | DXB    | LHR         | 1    |    | Economy |          | 0        | 0        | 0       | all        |
      | DXB    | LHR         | 1    |    | Economy |          |          |          |         | all        |


  Scenario Outline: Check the optional element validation
    Given call the calendar fare api with "<origin>", "<destination>", "<from>", "<to>", "<cabin>", "<adtCount>", "<chdCount>", "<infCount>", "<airline>", "<type>"
    Then validate the error response code for optional element validation

    Examples:
      | origin | destination | from | to | cabin   | adtCount | chdCount | infCount | airline | type       |
      | DXB    | LHR         | 1    | 1  | Economy | 1        | 0        | 0        | 0       | noAirline  |
      | DXB    | LHR         | 1    | 1  | Economy | 1        | 0        | 0        | 0       | noTimeSlot |
      | DXB    | LHR         |      | 1  | Economy | 1        | 0        | 0        | 0       | all        |
      | DXB    | LHR         | 1    |    | Economy | 1        | 0        | 0        | 0       | all        |
      | DXB    | LHR         |      |    | Economy | 1        | 0        | 0        | 0       | all        |

