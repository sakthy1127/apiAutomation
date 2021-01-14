@Regression
Feature: Get AutoComplete

  @severity=critical
  @issue=101
  @tmsLink=101
  Scenario: verify get autocomplete resposne code
    Given call the autocomplete API with "CHENNAI"
    Then verify the status code

  @severity=blocker
  @issue=1234
  @tmsLink=1234
  Scenario: To verify the response structure
    Given call the autocomplete API with "MAA"
    Then verify the status code
    Then verify the response with actual json schema
    Then verify the json structure has locations as List
    Then verify the location element of the resposne has all the required key
    Then verify the json structure has hotels as List
    Then verify the hotel element of the resposne has all the required key

  @severity=minor
  Scenario Outline: To Verify the location and hotel count in the resposne
    Given call the autocomplete API with different "<input>"
    Then verify the status code
    Then verify the size of the locations List as 5
    Then verify the size of the hotel List as 5
    Then verify the typeNameAr text is arabic

    Examples:
      | input   |
      | CHE     |
      | CHENNAI |

  Scenario Outline: verify the display type for hotel and location
    Given call the autocomplete API with "<length>"
    Then verify the status code
    Then verify the display type of locations
    Then verify the display type of hotels

    Examples:
      | length |
      | CHNNAI |
      | DUBAI  |
      | LONDON |


