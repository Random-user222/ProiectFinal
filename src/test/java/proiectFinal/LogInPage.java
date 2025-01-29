package proiectFinal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class LogInPage extends BasePage {

    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div[2]/div[2]/button[1]/p")
    private WebElement againAcceptCookies;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
    private WebElement logInEmailAddress;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")
    private WebElement logInPassword;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
    private WebElement logInButton;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void logInPageActions(Map<String, Object> logInFormData) {
        List<String> emailAddressInputValues = (List<String>) logInFormData.get("emailAddressValues");
        List<String> passwordInputValues = (List<String>) logInFormData.get("passwordValues");
        for (int index = 0; index < emailAddressInputValues.size(); index++) {
            logInEmailInput(emailAddressInputValues.get(index));
            logInPasswordInput(passwordInputValues.get(index));
            elementsHelper.clickElement(logInButton);
            logInPassword.clear();
            logInEmailAddress.clear();
        }
//        provideLogInData();
//        usingDataProviderInTheForm(logInEmailAddress.getText(), logInPassword.getText());
    }

    public void logInEmailInput(String emailAddressValues) {
        elementsHelper.fillElement(logInEmailAddress, emailAddressValues);
    }

    public void logInPasswordInput(String passwordValues){
        elementsHelper.fillElement(logInPassword, passwordValues);
    }

    @Override
   public void isPageLoaded() {
    }
}
