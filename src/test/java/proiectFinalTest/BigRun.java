package proiectFinalTest;

import org.testng.annotations.Test;
import proiectFinal.LogInPage;
import proiectFinal.NewUserSignUpForm;
import proiectFinal.SignUpFullForm;
import proiectFinal.HomePage;
import propertyUtility.PropertyUtility;
import webHelper.ElementsHelper;

import java.awt.*;
import java.util.Map;

public class BigRun extends TestPage{

    @Test
    public void homePageTest() throws InterruptedException, AWTException {
        ElementsHelper elementsHelper = new ElementsHelper(driver);
        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();
        homePage.actionsOnHomePage();
        NewUserSignUpForm newUserSignUpForm = new NewUserSignUpForm(driver);
        propertyUtility = new PropertyUtility("SignUp");
        Map<String, Object> signUpData = propertyUtility.getAllProperties();
        newUserSignUpForm.createANewAccount(signUpData);
        SignUpFullForm signUpFullForm = new SignUpFullForm(driver);
        propertyUtility = new PropertyUtility("SignUp");
        Map <String, Object> fullFormData = propertyUtility.getAllProperties();
        signUpFullForm.fillEntireFormWithPropertiesData(fullFormData);
        signUpFullForm.isPageLoaded();
        homePage.deleteAccount();
        homePage.goToHomePage();
        homePage.clickOnSignUpOrLogIn();
        LogInPage logInPage = new LogInPage(driver);
        propertyUtility = new PropertyUtility("LogIn");
        Map<String, Object> logInData = propertyUtility.getAllProperties();
        logInPage.logInPageActions(logInData);

    }
}
