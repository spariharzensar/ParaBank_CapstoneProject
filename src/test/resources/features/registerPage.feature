Feature: User Registration

  Scenario: Validate user is able to register successfully
    Given user is on the registration page
    When user enters registration details
      | firstName | Sandeep     |
      | lastName  | Parihar     |
      | address   | Street 1    |
      | city      | Pune        |
      | state     | MH          |
      | zipCode   | 10000       |
      | phone     | 1234567890  |
      | ssn       | 1234        |
    And clicks on register button
    Then user should be registered successfully
      | expectedWelcomeText | Your account was created successfully. You are now logged in. |

  Scenario: Verify that user is able to login with created user
    Given user is on the login page
    When user enters login details
    And clicks on login button
    Then user should be login successfully