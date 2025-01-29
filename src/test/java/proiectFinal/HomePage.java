package proiectFinal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;

public class HomePage extends BasePage{

    @FindBy (xpath = "/html/body/div/div[2]/div[2]/div[2]/div[2]/button[1]/p")
    private WebElement acceptCookies;

    @FindBy (xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    private WebElement signUpOrLogIn;

    @FindBy (xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
    private WebElement deleteAccountButton;

    @FindBy (xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a")
    private WebElement goToHomePage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void actionsOnHomePage(){
        elementsHelper.clickElement(acceptCookies);
        elementsHelper.clickElement(signUpOrLogIn);
    }

    public void acceptCookies(){
        elementsHelper.clickElement(acceptCookies);
    }

    public void clickOnSignUpOrLogIn(){
        elementsHelper.clickElement(signUpOrLogIn);
    }

    public void goToHomePage(){
        elementsHelper.clickElement(goToHomePage);
    }

    public void deleteAccount(){
        elementsHelper.clickElement(deleteAccountButton);
    }
    @Override
    public void isPageLoaded() {
    }
}
