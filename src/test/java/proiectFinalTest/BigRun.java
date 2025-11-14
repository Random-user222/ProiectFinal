package proiectFinalTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import proiectFinal.*;
import propertyUtility.PropertyUtility;


import java.awt.*;
import java.util.Map;

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;

public class BigRun extends TestPage{

    @Test
    public void ProiectFinal()  {
        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the HomePage is loaded correctly");
        homePage.acceptCookies();
        logEvents(PASS_STEP, "Accept the cookies from the HomePage");
        ShoppingPage shoppingPage = new ShoppingPage(driver);
        shoppingPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the ShoppingPage is loaded correctly");
        shoppingPage.actionsOnShoppingPage();
        logEvents(PASS_STEP, "Adding items to the cart");
        homePage.seeCartPage();
        logEvents(PASS_STEP, "Check the cart after adding items to it");
        homePage.goToHomePage();
        logEvents(PASS_STEP, "Go back to the HomePage after the previous flow");
        homePage.clickOnSignUpOrLogIn();
        logEvents(PASS_STEP, "Click on SignUp button to start creating a new account");
        NewUserSignUpForm newUserSignUpForm = new NewUserSignUpForm(driver);
        propertyUtility = new PropertyUtility("SignUp");
        Map<String, Object> signUpData = propertyUtility.getAllProperties();
        newUserSignUpForm.createANewAccount(signUpData);
        SignUpFullForm signUpFullForm = new SignUpFullForm(driver);
        propertyUtility = new PropertyUtility("SignUp");
        Map <String, Object> fullFormData = propertyUtility.getAllProperties();
        signUpFullForm.fillEntireFormWithPropertiesData(fullFormData);
        logEvents(PASS_STEP, "Filling the SignUp form by using DataProperties");
        signUpFullForm.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the SignUp Page is loaded correctly");
        homePage.seeCartPage();
        logEvents(PASS_STEP, "Check the cart after creating the account");
        homePage.goToHomePage();
        logEvents(PASS_STEP, "Go back to the HomePage after the previous flow");
        ReviewProductPage reviewProductPage = new ReviewProductPage(driver);
        reviewProductPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the ReviewPage is loaded correctly");
        reviewProductPage.fillReviewForm();
        logEvents(PASS_STEP, "Add a review to a product");
        homePage.goToHomePage();
        logEvents(PASS_STEP, "Go back to the HomePage after the previous flow");
        homePage.clickOnLogOutButton();
        logEvents(PASS_STEP, "Click on LogOut button");
        LogInPage logInPage = new LogInPage(driver);
        logInPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the LogIn Page is loaded correctly");
        propertyUtility = new PropertyUtility("LogIn");
        Map<String, Object> logInData = propertyUtility.getAllProperties();
        logInPage.logInPageActions(logInData);
        logEvents(PASS_STEP, "LogIn into the account we created previously");
        homePage.seeCartPage();
        logEvents(PASS_STEP, "Verify if the items we selected are still in the cart");
        homePage.goToHomePage();
        logEvents(PASS_STEP, "Go back to the HomePage after the previous flow");
        homePage.clickOnSignUpOrLogIn();
        logEvents(PASS_STEP, "Click on LogIn button");
        InvalidLogInPage invalidLogInPage = new InvalidLogInPage(driver);
        propertyUtility = new PropertyUtility("InvalidLogIn");
        Map<String, Object> invalidLogIn = propertyUtility.getAllProperties();
        invalidLogInPage.fillLogInFormWithInvalidData(invalidLogIn);
        logEvents(PASS_STEP, "Fill the LogIn form by using invalid values and DataProperties");
        homePage.deleteAccount();
        logEvents(PASS_STEP, "Last step, we delete the account");
        homePage.goToHomePage();
        logEvents(PASS_STEP, "Go back to the HomePage after the previous flow");
    }
}
