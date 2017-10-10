Feature: Event creation

  Background:
    Given I open a browser and go to desktop login page
    And I login as valid user

  Scenario: Create event with all possible options
    When I am at Dashboard page
    Then I create a new Event using CAB
    Then I enter Entity Description "Event 001"
    And I verify Entity Description "Event 001"
    And I clear Entity Description
    And I enter note with "Note 001" text
    And I upload PNG image
    And I set location to "Berlin"
    And I associate it with "Music dep"

    Then I wait for 5 seconds
