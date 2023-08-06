package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation {
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement inputPhone;

    @FindBy(xpath = "//*[@id=\"country\"]")
    private WebElement inputCountry;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement inputCity;

    @FindBy(xpath = "//*[@id=\"postCode\"]")
    private WebElement inputPostCode;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/button[2]")
    private WebElement clickNextContactInformation;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/h3")
    private WebElement contactInformationHeader;


    public ContactInformation(WebDriver driver) { //acesta este constructorul
        PageFactory.initElements(driver, this);
    }

    public void inputValueInEmailField (String string) {inputEmail.sendKeys(string);}

    public void inputPhoneNumberField (String string) {inputPhone.sendKeys(string);}

    public void inputCountry (String string) {inputCountry.sendKeys(string);}

    public void inputCity (String string) {inputCity.sendKeys(string);}

    public void inputCodePost (String string) {inputPostCode.sendKeys(string);}

    public void clickNextButtonContactInformation () {clickNextContactInformation.click();}

    public String getContactInformationHeaderText() {
        return contactInformationHeader.getText();
    }

    public void fillInContactInformationWithValidData() {
        inputValueInEmailField("tester@test.com");
        inputPhoneNumberField("0740 000 000");
        inputCountry("Djibouti");
        inputCity("Obock");
        inputCodePost("500 500");
        clickNextButtonContactInformation();
    }
}


