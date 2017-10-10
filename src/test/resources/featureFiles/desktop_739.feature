@desktop @format_filters @test739
Feature: Control Panel - Formats filter

  Background:
    Given I open a browser and go to desktop login page
    And I am at Login page
    Then I login as valid user
    And I navigate to Dashboard

  Scenario: Test 739: Control Panel - creating required test data
    When I am at "Dashboard" page
    Then I create a new Story using CAB
    And I am at new Entity creation page
    And I enter Entity Description "Test 739: Story without content"
    And I delete first Text article at Tasks Panel
    Then I click SAVE & NEXT bottom button
    And I enter Entity Description "Test 739: Story with Text only"
    Then I click SAVE & NEXT bottom button
    And I enter Entity Description "Test 739: Story with Photo only"
    And I add Photo task to Entity
    And I delete first Text article at Tasks Panel
    Then I click SAVE & NEXT bottom button
    And I enter Entity Description "Test 739: Story with Audio only"
    And I add Audio task to Entity
    And I delete first Text article at Tasks Panel
    Then I click Save Entity top link
    And I am at Dashboard page

  Scenario: Test 739: Control Panel - verify default filter's values
    When I am at "Dashboard" page
    Given I reset all Dashboard filters
    And I verify that "DASHBOARD" is selected in navigation panel menu
    And I click open filters at Control Panel
    Then I verify that Status additional filter has "All statuses" value
    And I verify that Tasks additional filter has "Any task" value
    And I verify that Users additional filter has "All" value
    Then I click on Tasks filter
    And I verify that parent filter option "All" is checked
    And I verify child filter options checked status
      | Text          | checked |
      | Photo         | checked |
      | Photo Gallery | checked |
      | Graphic       | checked |
      | Video         | checked |
      | Audio         | checked |
      | Live          | checked |
      | Table         | checked |
      | Poll          | checked |
      | Quiz          | checked |
      | Sweepstakes   | checked |
      | Advertisement | checked |
      | Other         | checked |
      | Other (2)     | checked |
      | Other (3)     | checked |
      | Other (4)     | checked |
      | Other (5)     | checked |
      | No tasks      | checked |
    Then I press CANCEL in filters pop-up
    And I verify that Tasks additional filter has "Any task" value
    And I verify APPLY filters button is disabled

  Scenario: Test 739: Control Panel - verify filtering
    When I am at "Dashboard" page
    And I click open filters at Control Panel
    Then I click on Tasks filter
    And I uncheck All filters
    And I check "Text" filter
    Then I press ENTER in filters pop-up
    And I verify that Tasks additional filter has "Text" value
    And I verify APPLY filters button is enabled
    Then I click APPLY filters button
    And I see active filters: "tasks"
    And I verify that "Test 739: Story with Text only" displayed at Story List

    Then I click open filters at Control Panel
    And I click on Tasks filter
    And I check "Photo" filter
    Then I press ENTER in filters pop-up
    And I verify that Tasks additional filter has "2 selected" value
    Then I click APPLY filters button
    And I see active filters: "tasks"
    And I verify that "Test 739: Story with Text only" displayed at Story List
    And I verify that "Test 739: Story with Photo only" displayed at Story List

    Then I click open filters at Control Panel
    And I click on Tasks filter
    And I uncheck "Photo" filter
    And I uncheck "Text" filter
    And I check "No tasks" filter
    Then I press ENTER in filters pop-up
    And I verify that Tasks additional filter has "No tasks" value
    Then I click APPLY filters button
    And I see active filters: "tasks"
    And I verify that "Test 739: Story without content" displayed at Story List

    Then I click open filters at Control Panel
    And I click on Tasks filter
    And I check "Audio" filter
    And I check "Text" filter
    Then I press ENTER in filters pop-up
    And I verify that Tasks additional filter has "3 selected" value
    Then I click APPLY filters button
    And I see active filters: "tasks"
    And I verify that "Test 739: Story without content" displayed at Story List
    And I verify that "Test 739: Story with Text only" displayed at Story List
    And I verify that "Test 739: Story with Audio only" displayed at Story List

  Scenario: Test 739: Control Panel - verify selected filters on other pages
    When I am at "Dashboard" page
    Then I navigate to Story - Ideas
    And I am at "Story Ideas" page
    Then I click open filters at Control Panel
    And I verify that Tasks additional filter has "3 selected" value

    Then I navigate to Story - Short-term
    And I am at "Short-term Planning" page
    Then I click open filters at Control Panel
    And I verify that Tasks additional filter has "3 selected" value

    Then I navigate to Story - Long-term
    And I am at "Long-term Planning" page
    Then I click open filters at Control Panel
    And I verify that Tasks additional filter has "3 selected" value

    Then I navigate to Calendar - Short-term
    And I am at "Short-term Calendar" page
    Then I click open filters at Control Panel
    And I verify that Tasks additional filter has "3 selected" value

    Then I navigate to Calendar - Long-term
    And I am at "Long-term Calendar" page
    Then I click open filters at Control Panel
    And I verify that Tasks additional filter has "3 selected" value

    Then I navigate to Management - Alerts
    And I am at "Alerts" page
    Then I click open filters at Control Panel
    And I verify that Tasks additional filter has "3 selected" value

    Then I navigate to Management - Timeline
    And I am at "Timeline" page
    Then I click open filters at Control Panel
    And I verify that Tasks additional filter has "3 selected" value

    Then I navigate to My Schedule
    And I am at "My Schedule" page
    Then I click open filters at Control Panel
    And I do not see Status filter
    And I do not see Tasks filter
    And I do not see Users filter

  Scenario: Test 739: Control Panel - Advanced Search
    When I navigate to Advanced Search
    And I enter "Test 739" into advanced search
    And I select Limit to these for 'Assigned to' option
    Then I click on "Any task"
    And I verify child filter options checked status
      | Text          | checked |
      | Photo         | checked |
      | Photo Gallery | checked |
      | Graphic       | checked |
      | Video         | checked |
      | Audio         | checked |
      | Live          | checked |
      | Table         | checked |
      | Poll          | checked |
      | Quiz          | checked |
      | Sweepstakes   | checked |
      | Advertisement | checked |
      | Other         | checked |
      | Other (2)     | checked |
      | Other (3)     | checked |
      | Other (4)     | checked |
      | Other (5)     | checked |
      | No tasks      | checked |
    Then I uncheck All filters
    And I check "Text" filter
    And I check "Audio" filter
    And I check "No tasks" filter
    Then I press ENTER in filters pop-up
    Then I click on Search button
    And I am at "Search results" page
    And I see "Test 739: Story with Text only" at searching results
    And I see "Test 739: Story with Audio only" at searching results
    And I see "Test 739: Story without content" at searching results
    And I do not see "Test 739: Story with Photo only" at searching results

  Scenario: Test 739: Control Panel - event filters
    When I am at Dashboard page
    And I reset all Dashboard filters
    Then I create a new Event using CAB
    And I am at new Entity creation page
    Then I enter Entity Description "Test 739 - SHOW"
    And I add Live task to Entity
    Then I add "NY Times" platform to Entity
    And I add "NY Times (Online)" platform to Entity
    Then I set platform category to "spo2"
    And I set publication date to "Story idea (no date)"
    Then I click Save Entity top link
    And I am at Dashboard page
    Then I navigate to Story - Ideas
    And I see "Test 739 - SHOW" at "spo2" Story Idea section
    Then I navigate to Story - Short-term
    And I see "Test 739 - SHOW" at "spo2" Story Idea section
    Then I navigate to Story - Long-term
    And I see "Test 739 - SHOW" at "spo2" Story Idea section
    Then I navigate to Calendar - Short-term
    And I see "Test 739 - SHOW" at "spo2" Story Idea section
    Then I navigate to Calendar - Long-term
    And I see "Test 739 - SHOW" at "spo2" Story Idea section
    And I wait for 5 seconds