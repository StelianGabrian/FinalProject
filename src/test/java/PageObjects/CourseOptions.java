package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseOptions {
    @FindBy(xpath = "//*[@id=\"flexRadioButton1\"]")
    private WebElement radio_button_manual_tester_certificate;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[3]/button[2]")
    private WebElement course_options_next_button;

    public CourseOptions(WebDriver driver) { //acesta este constructorul
        PageFactory.initElements(driver, this);
    }

    public void clickRadioButtonManualTester() {radio_button_manual_tester_certificate.click();}

    public void click_course_options_next_button() {course_options_next_button.click();}

    public void fillInCourseOptionsWithValidData() {
        clickRadioButtonManualTester();
        click_course_options_next_button();
    }
}
