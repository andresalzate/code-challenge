Feature: User management

  As an admin, I need to insert new users, so that, new users can access to the system.

  Scenario Outline: Create new user
    Given User who his name is <name> and his job is <job>
    When Admin tries to create the new user
    Then User should be created successful
    Examples:
      | name      | job                 |
      | Test User | Automation Engineer |