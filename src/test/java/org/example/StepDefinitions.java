package org.example;

import PageObjects.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
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


    @Given("I am on the main page")
    public void i_am_on_the_main_page() {
        driver.get("file:///E:/Stelica/Curs%20IT/Testing-Env-master/index.html");
    }

    @Given("I am on the Personal Information Page")
    public void i_am_on_the_Personal_Information_Page() {
        driver.get("file:///E:/Stelica/Curs%20IT/Testing-Env-master/routes/enrollment.html");
    }

    @Given("I am on Contact Information Page")
    public void i_am_on_the_Contact_Information_Page() {
        driver.get("file:///E:/Stelica/Curs%20IT/Testing-Env-master/routes/enrollment.html");
        personalInformation.fillInPersonalInformationWithValidData();
    }

    @Given("I am on Course Options Page")
    public void i_am_on_the_Course_Options_Page() {
        driver.get("file:///E:/Stelica/Curs%20IT/Testing-Env-master/routes/enrollment.html");
        personalInformation.fillInPersonalInformationWithValidData();
        contactInformation.fillInContactInformationWithValidData();
    }
    @Given("I am on the Payment Information Page")
    public  void i_am_on_the_Payment_Information_Page() {
        driver.get("file:///E:/Stelica/Curs%20IT/Testing-Env-master/routes/enrollment.html");
        personalInformation.fillInPersonalInformationWithValidData();
        contactInformation.fillInContactInformationWithValidData();
        courseOptions.fillInCourseOptionsWithValidData();
    }

    @Given("I am on Registration Confirmation Page")
    public void i_am_on_Registration_Confirmation_Page() {
        driver.get("file:///E:/Stelica/Curs%20IT/Testing-Env-master/routes/enrollment.html");
        personalInformation.fillInPersonalInformationWithValidData();
        contactInformation.fillInContactInformationWithValidData();
        courseOptions.fillInCourseOptionsWithValidData();
        paymentInformation.fillInPaymentInformationWithValidData();
    }

    @When("the email value of {string} is inputted")
    public void input_email_to_field(String string) {
        mainPage.inputValueInEmailField(string);
    }

    @When("the submit button is clicked")
    public void click_submit_button() {
        //Utils.scrollToElement(driver, mainPage.getVirtualHeader());
        mainPage.clickOnSubmitButton();
    }

    @When("I input {string} in the First Name field")
    public void input_First_Name(String string){
        personalInformation.inputValueInFirstNameField(string);
    }

    @When("In Contact Information Page I input e-mail value {string}")
    public void input_Contact_Information_email (String string) {contactInformation.inputValueInEmailField(string);}

    @When("I click radio button for Manual tester certificate")
    public void click_manual_tester_certificate_radio_button() {courseOptions.clickRadioButtonManualTester();
    }

    @When("I click radio button for Security tester certificate")
    public void click_Security_tester_certificate_radio_button() {
        courseOptions.clickRadioButtonSecurityTesterCertificate();
    }

    @When("I input {string} in the Card holder name")
    public void input_Card_holder_name (String string) { paymentInformation.inputCardHolderName(string);}

    @When("I click Return to homepage button")
    public void click_return_to_home_page_button () {registrationConfirmation.clickReturnToHomepage();}

    @When("I click Read more button for Selenium")
    public void click_Read_more_Selenium() {
        Utils.scrollToElement(driver, mainPage.getVirtualHeader());
        mainPage.clickReadMoreAboutSelenium();}


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

    @And("In Contact Information Page I input phone number {string}")
    public void input_Phone_Number(String string) {contactInformation.inputPhoneNumberField(string);}

    @And("In Contact Information Page I input Country name by value {string}")
    public void input_Country_Name(String string) {contactInformation.inputCountry(string);}

    @And("In Contact Information Page I input City name by value {string}")
    public void input_City_name (String string) {contactInformation.inputCity(string);}

    @And("In Contact Information Page I input Post Code number by value {string}")
    public void input_Post_Code(String string) {contactInformation.inputCodePost(string);}

    @And("In Contact Information Page I click Next button")
    public void click_Next_Button() {contactInformation.clickNextButtonContactInformation();}

    @And("I click Next button in Course Options Page")
    public void click_Next_button_in_Course_Option_Page() {courseOptions.clickCourseOptionsNextButton();
    }

    @And("I click Back button in Course Options Page")
    public void click_Back_button_in_Course_Option_Page() {courseOptions.clickCourseOptionsBackButton();}

    @And("I input value {string} in Card number field")
    public void input_Card_number_in_the_Payment_Information_Page(String string) {
        paymentInformation.inputCardNumber(string);
    }

    @And("I input value {string} in CVC number field")
    public void input_CVC_number_in_the_Payment_Information_Page(String string) {
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

    @And("I click on Year dropdown button")
    public void click_Year_dropdown_button() {
        paymentInformation.clickDropdownYear();
    }

    @And("I click on 2024 year from dropdown list")
    public void click_on_2024_year() {
        paymentInformation.clickYear2024();
    }

    @And("I click on Next button on Payment Information Page")
    public void click_Next_button_on_Payment_Information_Page() {
        paymentInformation.clickNextButtonOnPaymentInformation();
    }


}
