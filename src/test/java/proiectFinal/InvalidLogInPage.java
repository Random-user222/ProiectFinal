package proiectFinal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;

import java.util.List;
import java.util.Map;

public class InvalidLogInPage extends BasePage{
    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement logInEmailAddress;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement logInPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement logInButton;

    public InvalidLogInPage(WebDriver driver) {
        super(driver);
    }

    public void fillLogInFormWithInvalidData(Map<String, Object> invalidLogInData){
        List<String> invalidEmailValues = (List<String>) invalidLogInData.get("invalidEmailAddressValues");
        List<String> invalidPasswordValues = (List<String>) invalidLogInData.get("invalidPasswordValues");
        for (int index = 0; index<invalidEmailValues.size(); index++) {
            invalidLogInEmailInput(invalidEmailValues.get(index));
            invalidLogInPasswordInput(invalidPasswordValues.get(index));
            elementsHelper.clickElement(logInButton);
            try {
                WebElement emailField = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
                emailField.clear();
            } catch (Exception e) {
                System.out.println("Email input not found. Ignoring this step.");
            }

            try {
                WebElement emailField = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
                emailField.clear();
            } catch (Exception e) {
                System.out.println("Password input not found. Ignoring this step.");
            }
            logEvents(INFO_STEP, "Using DataProperties to LogIn with invalid data and adding try-catch to stop searching for the inputs after they are used");
        }
    }

    public void invalidLogInEmailInput(String emailAddressValues){
        elementsHelper.fillElement(logInEmailAddress, emailAddressValues );
    }


    public void invalidLogInPasswordInput(String passwordValues){
        elementsHelper.fillElement(logInPassword, passwordValues);
    }

    @Override
    public void isPageLoaded() {
    }
}
