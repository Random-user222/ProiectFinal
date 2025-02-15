package proiectFinal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;

import java.util.List;
import java.util.Map;

public class NewUserSignUpForm extends BasePage{

    @FindBy (xpath = "//input[@data-qa='signup-name']")
    private WebElement newUserName;

    @FindBy (xpath = "//input[@data-qa='signup-email']")
    private WebElement newUserEmail;

    @FindBy (xpath = "//button[@data-qa='signup-button']")
    private WebElement signUpButton;


    public NewUserSignUpForm(WebDriver driver) {
        super(driver);
    }

    public void createANewAccount(Map< String, Object > signUpFormData){
        newUserNameInput((String) signUpFormData.get("newUserName"));
        newUserEmailInput((String) signUpFormData.get("newUserEmail"));
        elementsHelper.clickElement(signUpButton);
        logEvents(INFO_STEP, "Using DataProperties to fill new UserName and Email to create a new account");
    }

    public void newUserNameInput(String userName){
        elementsHelper.fillElement(newUserName, userName);
    }

    public void newUserEmailInput(String userEmail){
        elementsHelper.fillElement(newUserEmail, userEmail);
    }

    @Override
   public void isPageLoaded() {
    }
}
