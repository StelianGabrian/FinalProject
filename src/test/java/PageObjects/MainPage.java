package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "/html/body/section[2]/div/div/div/input") //aici imi definesc elementele
    private WebElement inputEmailField;

    @FindBy(xpath = "/html/body/section[2]/div/div/div/button")
    private WebElement elementSubmitButton;

    @FindBy(xpath ="/html/body/section[3]/div/div/div[1]/div/div/h3")//pentru a ma deplasa cu scroll in pagina la acest element
    private WebElement virtualHeader;

    public MainPage(WebDriver driver) { //acesta este constructorul
        PageFactory.initElements(driver, this);
    }
    public void inputValueInEmailField(String string) { //aici scriem metoda care imi va face actiunile dorite
        inputEmailField.sendKeys(string);
    }
    public void clickOnSubmitButton() {
        elementSubmitButton.click();
    }
    public WebElement getVirtualHeader() {
        return virtualHeader;
    }
}
