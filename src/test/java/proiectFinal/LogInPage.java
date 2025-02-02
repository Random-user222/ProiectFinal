package proiectFinal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;

import java.util.Map;

public class LogInPage extends BasePage {

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement logInEmailAddress;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement logInPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement logInButton;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void logInPageActions(Map<String, Object> logInFormData) {
        logInEmailInput((String) logInFormData.get("emailAddressValues"));
        logInPasswordInput((String) logInFormData.get("passwordValues"));
        elementsHelper.clickElement(logInButton);
        logEvents(INFO_STEP, "Using DataProperties to fill the LogIn Form");
    }

    public void logInEmailInput(String emailAddressValues){
        elementsHelper.fillElement(logInEmailAddress, emailAddressValues );
        logEvents(INFO_STEP, "Fill email input with valid values");
    }

    public void logInPasswordInput(String passwordValues){
        elementsHelper.fillElement(logInPassword, passwordValues);
        logEvents(INFO_STEP, "Fill password input with valid values");
    }

    @Override
    public void isPageLoaded() {
    }
}
