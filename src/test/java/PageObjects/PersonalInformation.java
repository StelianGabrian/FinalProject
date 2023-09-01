package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInformation {
    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement inputFirstNameField;

    @FindBy(xpath = "//*[@id=\"lastName\"]")
    private WebElement inputLastNameField;

    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement inputUsernameField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement inputPasswordField;

    @FindBy(xpath = "//*[@id=\"cpassword\"]")
    private WebElement inputConfirmPasswordField;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[1]/button")
    private WebElement personalInformationNextButton;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[1]/h3")
    private WebElement personalInformationHeader;

    //Constructor
    public PersonalInformation(WebDriver driver) { //acesta este constructorul
        PageFactory.initElements(driver, this);
    }

    public void inputValueInFirstNameField(String string) {inputFirstNameField.sendKeys(string);}

    public void inputValueInTheLastNameField(String string) {inputLastNameField.sendKeys(string);}

    public void inputValueInTheUsernameField(String string) {inputUsernameField.sendKeys(string);}

    public void inputValueInThePasswordField(String string) {inputPasswordField.sendKeys(string);}

    public void inputConfirmPasswordField(String string) {inputConfirmPasswordField.sendKeys(string);}

    public void clickPersonalInformationNextButton() {personalInformationNextButton.click();}

    public String getPersonalInformationHeaderText() {
        return personalInformationHeader.getText();
    }

    public void fillInPersonalInformationWithValidData() {
        inputValueInFirstNameField("Ana");
        inputValueInTheLastNameField("Popescu");
        inputValueInTheUsernameField("John");
        inputValueInThePasswordField("bluewhales2*");
        inputConfirmPasswordField("bluewhales2*");
        clickPersonalInformationNextButton();
    }
}
