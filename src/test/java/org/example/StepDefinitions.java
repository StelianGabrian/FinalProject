package org.example;

import PageObjects.MainPage;
import PageObjects.PersonalInformation;
import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StepDefinitions {
    private WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    MainPage mainPage;//creez un obiect cu numele mainPage in interiorul clasei MainPage
    PersonalInformation personalInformation; //creez un obiect cu numele personalInformation in interiorul clasei PersonalInformation


    public StepDefinitions() {
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver); //adaug obiectul creat in interiorul contructorului
        personalInformation = new PersonalInformation(driver); //adaug obiectul creat in interiorul contructorului
    }

    @Given("I am on the main page")
    public void i_am_on_the_main_page() {
        driver.get("file:///E:/Stelica/Curs%20IT/Testing-Env-master/index.html");
    }

    @Given("I am on the Personal Information Page")
    public void i_am_on_the_Personal_Information_Page() {
        driver.get("file:///E:/Stelica/Curs%20IT/Testing-Env-master/routes/enrollment.html");
    }

    @When("the email value of {string} is inputted")
    public void input_email_to_field(String string) {
        mainPage.inputValueInEmailField(string);
    }

    @When("the submit button is clicked")
    public void click_submit_button() {
        Utils.scrollToElement(driver, mainPage.getVirtualHeader());
        mainPage.clickOnSubmitButton();
    }

        @When("I input {string} in the First Name field")
    public void input_First_Name(String string){
        personalInformation.inputValueInFirstNameField(string);
    }

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
    public void clik_Personal_Information_Next_button() {
        personalInformation.clickPersonalInformationNextButton();
    }
}
