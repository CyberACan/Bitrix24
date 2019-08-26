#  User story
# As a user I should be able to create a task from activity stream.
#  AC:
# Verify that user can create new task by clicking on tasks on activity stream.
# Verify that user can upload a file and image or link or add checklist regarding to
# new task.
# Verify that user should be able to set up a deadline for new task.

Feature: As a user I shoul be able to create a task from activity stream

  Background:
    Given user is on the landing page
    When user logs in as a hr
    Then user clicks "TASK" on the top menu
    And enters a "New task"

  Scenario: Verify that user can create new task by clicking on tasks on activity stream
    And user clicks "SEND" button
    Then "New task" is listed on activity stream

  Scenario: Verify that user can upload a file or link or add checklist regarding to new task
    And User clicks Checklist
    Then Checklist is displayed
    When user enters a checklist item
    Then checklist item is added to Checklist

  Scenario: Verify that user should be able to set up a deadline for new task
    And user clicks deadline field
    Then selected date is displayed on Deadline field



