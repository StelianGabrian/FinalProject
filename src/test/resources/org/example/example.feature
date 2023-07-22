Feature: An example

  Scenario: TC001 Valid email US
    Given I am on the main page
    When the email value of "tester@test.com" is inputted
    And the submit button is clicked

  Scenario: TC002 Valid email RO
    Given I am on the main page
    When the email value of "tester@test.ro" is inputted
    And the submit button is clicked

  Scenario: TC003 Negative over character limit
    Given I am on the main page
    When the email value of "Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" is inputted
    And the submit button is clicked

  Scenario: TC004 Input a valid First Name
    Given I am on the Personal Information Page
    When I input "Florin Cosmin" in the First Name field
    And I input "Popescu" in the Last Name field
    * I input "John" in the Username field
    * I input "bluewhales2*" in the Password field
    * I input "bluewhales2*" in the Confirm Password field
    * I click Personal Information Next button

  Scenario: TC005 Input a invalid First Name - 26 characters
    Given I am on the Personal Information Page
    When I input "Florinescuuuuuuuuuuuuuuuuu" in the First Name field
    And I input "Popescu" in the Last Name field
    * I input "John" in the Username field
    * I input "bluewhales2*" in the Password field
    * I input "bluewhales2*" in the Confirm Password field
    * I click Personal Information Next button

  Scenario: TC006 Input a invalid First Name - letters and numbers
    Given I am on the Personal Information Page
    When I input "Florin 2 * +-/^ " in the First Name field
    And I input "Popescu" in the Last Name field
    * I input "John" in the Username field
    * I input "bluewhales2*" in the Password field
    * I input "bluewhales2*" in the Confirm Password field
    * I click Personal Information Next button

  Scenario: TC007 Input a valid Last Name
    Given I am on the Personal Information Page
    When I input "Florin" in the First Name field
    And I input "Popescu" in the Last Name field
    * I input "John" in the Username field
    * I input "bluewhales2*" in the Password field
    * I input "bluewhales2*" in the Confirm Password field
    * I click Personal Information Next button

  Scenario: TC008 Input valid values in Contact Information Page
    Given I am on Contact Information Page
    When In Contact Information Page I input e-mail value "tester@test.com"
    And In Contact Information Page I input phone number "0740 000 000"
    * In Contact Information Page I input Country name by value "Djibouti"
    * In Contact Information Page I input City name by value "Obock"
    * In Contact Information Page I input Post Code number by value "500 000"
    * In Contact Information Page I click Next button

  Scenario: TC009 Input valid data in Course Options
    Given I am on Course Options Page
    When I click radio button radio for manual tester certificate
    And I click Next button in Course Options Page

  Scenario: TC010 Input valid data up to Payment Information Page
    Given I am on the Payment Information Page
    When I input "Ionut Popescu" in the Card holder name
    And I input value "4444 4444 4444" in Card number field
    * I input value "430" in CVC number field
    * I click Month dropdown button
    * I click on January month from dropdown list
    * I click on Year dropdown button
    * I click on 2024 year from dropdown list
    * I click on Next button on Payment Information Page

    Scenario: TC0011 Input valid data in all fields and return to homepage
      Given I am Registration Confirmation Page
      When I click Return to homepage button
