Feature: Event creation

  Background:
    Given I open a browser and go to desktop login page
    And I login as "org1" user

  Scenario: Create event with all possible options
    When I am at Dashboard page
    Then I create a new Event using CAB

    Then I enter Entity Description "Event 001"
    And I verify Entity Description "Event 001"
    And I clear Entity Description

    Then I enter Entity Note "Note 001"
    And I verify Entity Note "Note 001"
    And I clear Entity Note

    Then I upload "desk-net.png" to Entity Attachments
    And I verify Entity Attachment has "desk-net.png"
    And I upload "desk-net.txt" to Entity Attachments
    And I verify Entity Attachment has "desk-net.txt"
    And I delete "desk-net.png" from Entity Attachments
    And I see confirmation dialog with title "Confirm file deletion"
    And I wait for a second
    And I click NO button at confirmation dialog
    And I verify Entity Attachment has "desk-net.png"
    And I delete "desk-net.png" from Entity Attachments
    And I see confirmation dialog with body "Do you really want to delete this file?"
    And I click YES button at confirmation dialog

    And I set location to "Berlin"
    And I wait for a second
    And I verify "Berlin" is current Entity Location
    And I remove current Entity Location

    And I remove all Entity Associations
    And I wait for a second
    And I add "Music dep" to Entity Associations
    And I check all Entity Associations


    Then I wait for 5 seconds