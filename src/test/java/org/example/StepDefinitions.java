package org.example;

import PageObjects.*;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class StepDefinitions {
    private WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    //creez un obiect cu numele mainPage in interiorul clasei MainPage
    MainPage mainPage;
    //creez un obiect cu numele personalInformation in interiorul clasei PersonalInformation
    PersonalInformation personalInformation;
    ContactInformation contactInformation;
    PaymentInformation paymentInformation;
    CourseOptions courseOptions;
    RegistrationConfirmation registrationConfirmation;

    /*------------------------------------------------CONSTRUCTOR-----------------------------------------------------*/
    public StepDefinitions() {
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver); //adaug obiectul creat in interiorul contructorului
        personalInformation = new PersonalInformation(driver); //adaug obiectul creat in interiorul contructorului
        contactInformation = new ContactInformation(driver);
        courseOptions = new CourseOptions(driver);
        paymentInformation = new PaymentInformation(driver);
        registrationConfirmation = new RegistrationConfirmation(driver);
    }

    /*----------------------------------------------------GIVEN-------------------------------------------------------*/
    @Given("I am on the main page")
    public void i_am_on_the_main_page() {
        driver.get("file:///E:/Stelica/Curs%20IT/Testing-Env-master/index.html");
    }

    @Given("I am on the Personal Information form")
    public void i_am_on_the_Personal_Information_form() {
        driver.get("file:///E:/Stelica/Curs%20IT/Testing-Env-master/routes/enrollment.html");
    }

    @Given("I am on Contact Information form")
    public void i_am_on_the_Contact_Information_form() {
        driver.get("file:///E:/Stelica/Curs%20IT/Testing-Env-master/routes/enrollment.html");
        personalInformation.fillInPersonalInformationWithValidData();
    }

    @Given("I am on Course Options form")
    public void i_am_on_the_Course_Options_form() {
        driver.get("file:///E:/Stelica/Curs%20IT/Testing-Env-master/routes/enrollment.html");
        personalInformation.fillInPersonalInformationWithValidData();
        contactInformation.fillInContactInformationWithValidData();
    }

    @Given("I am on the Payment Information form")
    public void i_am_on_the_Payment_Information_form() {
        driver.get("file:///E:/Stelica/Curs%20IT/Testing-Env-master/routes/enrollment.html");
        personalInformation.fillInPersonalInformationWithValidData();
        contactInformation.fillInContactInformationWithValidData();
        courseOptions.fillInCourseOptionsWithValidData();
    }

    @Given("I am on Registration Confirmation form")
    public void i_am_on_Registration_Confirmation_form() {
        driver.get("file:///E:/Stelica/Curs%20IT/Testing-Env-master/routes/enrollment.html");
        personalInformation.fillInPersonalInformationWithValidData();
        contactInformation.fillInContactInformationWithValidData();
        courseOptions.fillInCourseOptionsWithValidData();
        paymentInformation.fillInPaymentInformationWithValidData();
    }

    /*----------------------------------------------------WHEN--------------------------------------------------------*/
    @When("the e-mail value of {string} is inputted")
    public void input_email_to_field(String string) {
        mainPage.inputValueInEmailField(string);
    }

    @When("the submit button is clicked")
    public void click_submit_button() {
        //Utils.scrollToElement(driver, mainPage.getVirtualHeader());
        mainPage.clickOnSubmitButton(); }

    @When("I input {string} in the First Name field")
    public void input_First_Name(String string) {
        personalInformation.inputValueInFirstNameField(string);
    }

    @When("In Contact Information form I input e-mail value {string}")
    public void input_Contact_Information_email(String string) {
        contactInformation.inputValueInEmailField(string);
    }

    @When("I click radio button for Manual tester certificate")
    public void click_manual_tester_certificate_radio_button() {
        courseOptions.clickRadioButtonManualTester();
    }

    @When("I click radio button for Security tester certificate")
    public void click_Security_tester_certificate_radio_button() {
        courseOptions.clickRadioButtonSecurityTesterCertificate(); }
    @When("I input {string} in the Card holder name")
    public void input_Card_holder_name(String string) {
        paymentInformation.inputCardHolderName(string);
    }

    @When("I click Return to homepage button")
    public void click_return_to_home_page_button() {
        registrationConfirmation.clickReturnToHomepage();
    }

    @When("I click Read more button for Selenium")
    public void click_Read_more_Selenium() {
        Utils.scrollToElement(driver, mainPage.getVirtualHeader());
        mainPage.clickReadMoreAboutSelenium(); }

    @When("I click Instructors button")
    public void click_Instructors_button() {
        mainPage.clickReadAboutInstructors();
    }


    /*----------------------------------------------------AND--------------------------------------------------------*/
    @And("I input {string} in the Last Name field")
    public void input_Last_Name_Field(String string) {
        personalInformation.inputValueInTheLastNameField(string);
    }

    @And("I input {string} in the Username field")
    public void input_Username_Field(String string) {
        personalInformation.inputValueInTheUsernameField(string);
    }

    @And("I input {string} in the Password field")
    public void input_Password_Field(String string) {
        personalInformation.inputValueInThePasswordField(string);
    }

    @And("I input {string} in the Confirm Password field")
    public void input_Confirm_Password_Field(String string) {
        personalInformation.inputConfirmPasswordField(string);
    }

    @And("I click Personal Information Next button")
    public void click_Personal_Information_Next_button() {
        personalInformation.clickPersonalInformationNextButton();
    }

    @And("In Contact Information form I input phone number {string}")
    public void input_Phone_Number(String string) {
        contactInformation.inputPhoneNumberField(string);
    }

    @And("In Contact Information form I input Country name by value {string}")
    public void input_Country_Name(String string) {
        contactInformation.inputCountry(string);
    }

    @And("In Contact Information form I input City name by value {string}")
    public void input_City_name(String string) {
        contactInformation.inputCity(string);
    }

    @And("In Contact Information form I input Post Code number by value {string}")
    public void input_Post_Code(String string) {
        contactInformation.inputCodePost(string);
    }

    @And("In Contact Information form I click Next button")
    public void click_Next_Button() {
        contactInformation.clickNextButtonContactInformation();
    }

    @And("I click Next button in Course Options form")
    public void click_Next_button_in_Course_Option_form() {
        courseOptions.clickCourseOptionsNextButton();
    }

    @And("I click Back button in Course Options form")
    public void click_Back_button_in_Course_Option_form() {
        courseOptions.clickCourseOptionsBackButton();
    }

    @And("I input value {string} in Card number field")
    public void input_Card_number_in_the_Payment_Information_form(String string) {
        paymentInformation.inputCardNumber(string); }

    @And("I input value {string} in CVC number field")
    public void input_CVC_number_in_the_Payment_Information_form(String string) {
        paymentInformation.inputCVC(string);
    }

    @And("I click Month dropdown button")
    public void click_Month_dropdown_button() {
        paymentInformation.clickDropdownMonth();
    }

    @And("I click on January month from dropdown list")
    public void click_on_January_month() {
        paymentInformation.clickMonthJanuary();
    }

    @And("I select month {string}")
    public void choose_a_month(String month) {
        paymentInformation.selectMonthByXpath(driver, month);
    }

    @And("I click on Year dropdown button")
    public void click_Year_dropdown_button() {
        paymentInformation.clickDropdownYear();
    }

    @And("I click on 2024 year from dropdown list")
    public void click_on_2024_year() {
        paymentInformation.clickYear2024();
    }

    @And("I select year {string}")
    public void choose_an_year(String year) {
        paymentInformation.selectYearByXpath(driver, year);
    }

    @And("I click on Next button on Payment Information form")
    public void click_Next_button_on_Payment_Information_form() {
        paymentInformation.clickNextButtonOnPaymentInformation();
    }


    /*----------------------------------------------------THEN--------------------------------------------------------*/
    @Then("the newsletter confirmation pop-up appears")
    public void theNewsletterConfirmationPopUpAppears() {
        Utils.waitForElementToLoad(1);
        driver.switchTo().alert().accept();
    }
    @Then("the placeHolder becomes red and I am not allowed to Submit")
    public void thePlaceHolderBecomesRed() {
        Assertions.assertTrue(driver.getPageSource().contains("error"));
    }
    @Then("the Contact information form opens")
    public void iAmAllowedToAccessTheContactInformationForm() {
        Assertions.assertEquals("Contact information", contactInformation.getContactInformationHeaderText());
    }
    @Then("I remain on Personal information form")
    public void iAmNotAllowedToAccessTheContactInformationForm() {
        Assertions.assertEquals ("Personal information",personalInformation.getPersonalInformationHeaderText());
    }
    @Then("the Selenium page opens")
    public void theSeleniumPageOpens() {
        Assertions.assertEquals("file:///E:/Stelica/Curs%20IT/Testing-Env-master/routes/selenium.html", driver.getCurrentUrl());
    }
    @Then("the page must scroll down to the Instructor section")
    public void thePageMustScrollDownToTheInstructorSection() {
        Assertions.assertTrue(driver.findElement(By.id("instructors")).isDisplayed());
    }
    @Then("the Course options form opens")
    public void theCourseOptionFormOpens() {
        Assertions.assertTrue( driver.findElement(By.xpath("/html/body/div/div/section/div/form/div[3]/h3")).isDisplayed());
    }
    @Then("the Payment Information form opens")
    public void thePaymentInformationFormOpens() {
        Assertions.assertTrue( driver.findElement(By.xpath("/html/body/div/div/section/div/form/div[4]/h3")).isDisplayed());
    }
    @Then("the successful registration message appears")
    public void theSuccessfulRegistrationMessageAppears() {
        Assertions.assertTrue( driver.findElement(By.xpath("//html/body/div/div/section/div/form/div[5]/h3")).isDisplayed());
    }
    @Then("I remain on Payment Information form")
    public void iRemainOnPaymentInformationForm() {
        Assertions.assertTrue( driver.findElement(By.xpath("/html/body/div/div/section/div/form/div[4]/h3")).isDisplayed());
    }
    @Then("the homepage opens")
    public void theHomepageOpens() {
        Assertions.assertEquals("file:///E:/Stelica/Curs%20IT/Testing-Env-master/index.html", driver.getCurrentUrl());
    }
    @Then("I remain on Course Options form")
    public void iRemainOnCourseOptionsForm() {
        Assertions.assertTrue( driver.findElement(By.xpath("/html/body/div/div/section/div/form/div[3]/h3")).isDisplayed());
    }
}