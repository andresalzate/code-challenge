Feature: Financial Info

  As a user, I need to check my financial info, so that, I can be aware of my expenses.

  Background: User is Logged In
    Given User with valid credentials
    When he logs in
    Then he should see the main page

  Scenario: Check overview info
    Then he should see valid info in his overview

  Scenario: Sort transactions by status
    When he sorts transactions by status
    Then he should see all the transactions sorted by status