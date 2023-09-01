Feature: An example

  Scenario: TC001 Valid e-mail for newsletter - RO
    Given I am on the main page
    When the e-mail value of "tester@test.ro" is inputted
    And the submit button is clicked
    Then the newsletter confirmation pop-up appears

  Scenario: TC002 Invalid e-mail for newsletter
    Given I am on the main page
    When the e-mail value of "Aaaaaaaaaaaaaaaaaaaaaaaaaaa" is inputted
    And the submit button is clicked
    Then I am not allowed to Submit

  Scenario: TC003 Input a valid First Name
    Given I am on the Personal Information form
    When I input "Florin Cosmin" in the First Name field
    And I input "Popescu" in the Last Name field
    * I input "John" in the Username field
    * I input "bluewhales2*" in the Password field
    * I input "bluewhales2*" in the Confirm Password field
    * I click Personal Information Next button
    Then the Contact information form opens

  Scenario: TC004 Invalid First Name - 26 characters
    Given I am on the Personal Information form
    When I input "Florinescuuuuuuuuuuuuuuuuu" in the First Name field
    And I input "Popescu" in the Last Name field
    * I input "John" in the Username field
    * I input "bluewhales2*" in the Password field
    * I input "bluewhales2*" in the Confirm Password field
    * I click Personal Information Next button
    Then I remain on Personal information form

  Scenario: TC005 Invalid First Name - letters, numbers and characters
    Given I am on the Personal Information form
    When I input "Florin 2 * +-/^ " in the First Name field
    And I input "Popescu" in the Last Name field
    * I input "John" in the Username field
    * I input "bluewhales2*" in the Password field
    * I input "bluewhales2*" in the Confirm Password field
    * I click Personal Information Next button
    Then I remain on Personal information form

  Scenario: TC006 Input a different Confirmation Password
    Given I am on the Personal Information form
    When I input "Florin" in the First Name field
    And I input "Popescu" in the Last Name field
    * I input "John" in the Username field
    * I input "bluewhales2*" in the Password field
    * I input "blue*" in the Confirm Password field
    * I click Personal Information Next button
    Then I remain on Personal information form

  Scenario: TC007 Read more about Selenium
    Given I am on the main page
    When I click Read more button for Selenium
    Then the Selenium page opens

  Scenario: TC008 Read about Instructors
    Given I am on the main page
    When I click Instructors button
    Then the page must scroll down to the Instructor section
    # Then the page scroll down to the Instructor section !!!!!

  Scenario: TC009 Input valid values in Contact Information form
    Given I am on Contact Information form
    When In Contact Information form I input e-mail value "tester@test.com"
    And In Contact Information form I input phone number "0740 000 000"
    * In Contact Information form I input Country name by value "Djibouti"
    * In Contact Information form I input City name by value "Obock"
    * In Contact Information form I input Post Code number by value "500 000"
    * In Contact Information form I click Next button
    Then the Course options form opens

  Scenario: TC010 Choose Manual Tester Certificate radio button in Course Options
    Given I am on Course Options form
    When I click radio button for Manual tester certificate
    And I click Next button in Course Options form
    Then the Payment Information form opens

  Scenario: TC0011 Choose none of the radio buttons in Course Options form
    Given I am on Course Options form
    When I click Next button in Course Options form
    Then I remain on Course Options form

  Scenario: TC0012 Click Back button in Course Options
    Given I am on Course Options form
    When I click Back button in Course Options form
    Then the Contact information form opens

  Scenario: TC013 Input valid data up to Payment Information form - testing dropdown buttons
    Given I am on the Payment Information form
    When I input "Ionut Popescu" in the Card holder name
    And I input value "4444 4444 4444" in Card number field
    * I input value "430" in CVC number field
    * I click Month dropdown button
    * I click on January month from dropdown list
    * I click on Year dropdown button
    * I click on 2024 year from dropdown list
    * I click on Next button on Payment Information form
    Then the successful registration message appears

  Scenario: TC014 Input valid data up to Payment Information form - Month & year without dropdown
    Given I am on the Payment Information form
    When I input "Ionut Popescu" in the Card holder name
    And I input value "4444 4444 4444" in Card number field
    * I input value "430" in CVC number field
    * I select month "February"
    * I select year "2024"
    * I click on Next button on Payment Information form
    Then the successful registration message appears

  Scenario: TC015 Input valid data up to Payment Information form,except Card holder name
    Given I am on the Payment Information form
    When I input value "4444 4444 4444" in Card number field
    And I input value "430" in CVC number field
    * I click Month dropdown button
    * I click on January month from dropdown list
    * I click on Year dropdown button
    * I click on 2024 year from dropdown list
    * I click on Next button on Payment Information form
    Then I remain on Payment Information form

  Scenario: TC016 Input valid data up to Payment Information form,except CVC number
    Given I am on the Payment Information form
    When I input "Ionut Popescu" in the Card holder name
    And I input value "4444 4444 4444" in Card number field
    * I click Month dropdown button
    * I click on January month from dropdown list
    * I click on Year dropdown button
    * I click on 2024 year from dropdown list
    * I click on Next button on Payment Information form
    Then I remain on Payment Information form

  Scenario: TC0017 Check return to homepage button from Enrollment page
    Given I am on Registration Confirmation form
    When I click Return to homepage button
    Then the homepage opens


