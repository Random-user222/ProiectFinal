package proiectFinal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;

public class HomePage extends BasePage{

    @FindBy (xpath = "//button[@aria-label='Consent']")
    private WebElement acceptCookies;

    @FindBy (xpath = "//i[@class='fa fa-lock']")
    private WebElement signUpOrLogIn;

    @FindBy (xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
    private WebElement deleteAccountButton;

    @FindBy (xpath = "//i[@class='fa fa-home']")
    private WebElement goToHomePage;

    @FindBy (xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    private WebElement logOutButton;

    @FindBy (xpath = "//i[@class=\"fa fa-shopping-cart\"]")
    private WebElement cartButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void acceptCookies(){
        elementsHelper.clickElement(acceptCookies);
        logEvents(INFO_STEP, "Accept the cookies from the HomePage");
    }

    public void clickOnSignUpOrLogIn(){
        elementsHelper.clickElement(signUpOrLogIn);
        logEvents(INFO_STEP, "Click on the SignUp/LogIn button");
    }

    public void goToHomePage(){
        elementsHelper.clickElement(goToHomePage);
        logEvents(INFO_STEP, "Return to the HomePage");
    }

    public void clickOnLogOutButton(){
        elementsHelper.clickElement(logOutButton);
        logEvents(INFO_STEP, "Click on LogOut button");
    }

    public void deleteAccount(){
        elementsHelper.clickElement(deleteAccountButton);
        logEvents(INFO_STEP, "Delete the account after creating one");
    }

    public void seeCartPage(){
        elementsHelper.clickElement(cartButton);
        logEvents(INFO_STEP, "Check the cart");
    }

    @Override
    public void isPageLoaded() {
    }
}
