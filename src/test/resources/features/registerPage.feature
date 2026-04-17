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
      | password  | pass123Test |
    And clicks on register button
    Then user should be registered successfully
      | expectedWelcomeText | Your account was created successfully. You are now logged in. |