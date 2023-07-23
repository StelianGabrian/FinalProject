package PageObjects;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseOptions {
    @FindBy(xpath = "//*[@id=\"flexRadioButton1\"]")
    private WebElement radio_button_manual_tester_certificate;

    @FindBy(xpath = "//*[@id=\"flexRadioButton4\"]")
    private WebElement radio_button_security_tester_certificate;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[3]/button[2]")
    private WebElement course_options_NEXT_button;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[3]/button[1]")
    private WebElement course_options_BACK_button;

    public CourseOptions(WebDriver driver) { //acesta este constructorul
        PageFactory.initElements(driver, this);
    }

    public void clickRadioButtonManualTester() {radio_button_manual_tester_certificate.click();}

    public void clickRadioButtonSecurityTesterCertificate() {radio_button_security_tester_certificate.click();}

    public void clickCourseOptionsNextButton() {
        course_options_NEXT_button.click();}

    public void clickCourseOptionsBackButton() {
        course_options_BACK_button.click();
    }

    public void fillInCourseOptionsWithValidData() {
        clickRadioButtonManualTester();
        clickCourseOptionsNextButton();
    }
}
