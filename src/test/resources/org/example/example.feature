Feature: An example

  Scenario: Valid email US
    Given I am on the main page
    When the email value of "tester@test.com" is inputted
    And the submit button is clicked

  Scenario: Valid email RO
    Given I am on the main page
    When the email value of "tester@test.ro" is inputted
    And the submit button is clicked

  Scenario: Negative over character limit
    Given I am on the main page
    When the email value of "Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" is inputted
    And the submit button is clicked

  Scenario: Input a valid First Name
    Given I am on the Personal Information Page
    When I input "Florin Cosmin" in the First Name field
    And I input "Popescu" in the Last Name field
    * I input "John" in the Username field
    * I input "bluewhales2*" in the Password field
    * I input "bluewhales2*" in the Confirm Password field
    * I click Personal Information Next button

  Scenario: Input a invalid First Name - 26 characters
    Given I am on the Personal Information Page
    When I input "Florinescuuuuuuuuuuuuuuuuu" in the First Name field
    And I input "Popescu" in the Last Name field
    * I input "John" in the Username field
    * I input "bluewhales2*" in the Password field
    * I input "bluewhales2*" in the Confirm Password field
    * I click Personal Information Next button

  Scenario: Input a invalid First Name - letters and numbers
    Given I am on the Personal Information Page
    When I input "Florin 2 * +-/^ " in the First Name field
    And I input "Popescu" in the Last Name field
    * I input "John" in the Username field
    * I input "bluewhales2*" in the Password field
    * I input "bluewhales2*" in the Confirm Password field
    * I click Personal Information Next button

  Scenario: Input a valid Last Name
    Given I am on the Personal Information Page
    When I input "Florin" in the First Name field
    And I input "Popescu" in the Last Name field
    * I input "John" in the Username field
    * I input "bluewhales2*" in the Password field
    * I input "bluewhales2*" in the Confirm Password field
    * I click Personal Information Next button