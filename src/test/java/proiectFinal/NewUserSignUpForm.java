package proiectFinal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class NewUserSignUpForm extends BasePage{

    @FindBy (xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")
    private WebElement newUserName;

    @FindBy (xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
    private WebElement newUserEmail;

    @FindBy (xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
    private WebElement signUpButton;

    public String email;

    public NewUserSignUpForm(WebDriver driver) {
        super(driver);
    }

    public void createANewAccount(Map< String, Object > signUpFormData){
        newUserNameInput((String) signUpFormData.get("newUserName"));
        email = System.currentTimeMillis() + (String) signUpFormData.get("newUserEmail");
        newUserEmailInput(email);
        elementsHelper.clickElement(signUpButton);
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
