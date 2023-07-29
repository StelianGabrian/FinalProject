package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentInformation {
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[2]/input")
    private WebElement inputCardHolderName;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[3]/div/div[1]/input")
    private WebElement inputCardNumber;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[3]/div/div[2]/input")
    private WebElement inputCVC;
    @FindBy(xpath = "//*[@id=\"month\"]")
    private WebElement clickDropdownMonth;
    @FindBy(xpath = "//*[@id=\"month\"]/option[2]")
    private WebElement clickMonthJanuary;
    @FindBy(xpath = "//*[@id=\"year\"]")
    private WebElement clickDropdownYear;
    @FindBy(xpath = "//*[@id=\"year\"]/option[5]")
    private WebElement clickYear2024;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[4]/button[2]")
    private WebElement clickNextButtonOnPaymentInformation;

    //acesta este constructorul
    public PaymentInformation(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void inputCardHolderName(String string) {inputCardHolderName.sendKeys(string);}
    public void inputCardNumber(String string) {
        inputCardNumber.sendKeys(string);
    }
    public void inputCVC(String string) {
        inputCVC.sendKeys(string);
    }
    public void clickDropdownMonth() {clickDropdownMonth.click(); }
    public void clickMonthJanuary() {
        clickMonthJanuary.click();
    }
    public void clickDropdownYear() {clickDropdownYear.click();}
    public void clickYear2024() {clickYear2024.click(); }
    public void clickNextButtonOnPaymentInformation() {clickNextButtonOnPaymentInformation.click();}

    public void selectMonthByXpath(WebDriver driver, String month) {
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"month\"]"));
        Select select = new Select(dropdown);
        select.selectByVisibleText(month);
    }
    public void selectYearByXpath(WebDriver driver, String year) {
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"year\"]"));
        Select select = new Select(dropdown);
        select.selectByVisibleText(year);
    }
    public void fillInPaymentInformationWithValidData() {
        inputCardHolderName("Ana Maria");
        inputCardNumber("0000 0000 0000");
        inputCVC("123");
        clickDropdownMonth();
        clickMonthJanuary();
        clickDropdownYear();
        clickYear2024();
        clickNextButtonOnPaymentInformation();
    }
}

