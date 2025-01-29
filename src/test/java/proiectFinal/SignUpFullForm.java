package proiectFinal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;

import java.util.List;
import java.util.Map;

public class SignUpFullForm extends BasePage{
        @FindBy(xpath = "//input[@type='text']")
        private WebElement newUserName;
        @FindBy(xpath= "//input[@data-qa='signup-email']")
        private WebElement newUserEmail;
        @FindBy(xpath = "//button[@data-qa='signup-button']")
        private WebElement signUpNewUser;
        @FindBy(xpath = "//*[@id=\"id_gender1\"]")
        private WebElement maleGenderElement;
        @FindBy(xpath = "//*[@id=\"password\"]")
        private WebElement fillPassword;
        @FindBy(xpath = "//*[@id=\"days\"]")
        private WebElement dayOfBirth;
        @FindBy(xpath = "//*[@id=\"newsletter\"]")
        private WebElement newsletter;
        @FindAll({
                @FindBy(id = "days"),
                @FindBy(id = "months"),
                @FindBy(id = "years")
        })
        private List<WebElement> dateOfBirth;

        @FindBy(xpath = "//*[@id=\"optin\"]")
        private WebElement specialOffers;

        @FindBy(xpath = "//*[@id=\"first_name\"]")
        private WebElement firstName;

        @FindBy(xpath = "//*[@id=\"last_name\"]")
        private WebElement lastName;

        @FindBy(xpath = "//*[@id=\"company\"]")
        private WebElement company;

        @FindBy(xpath = "//*[@id=\"address1\"]")
        private WebElement address1;

        @FindBy(xpath = "//*[@id=\"address2\"]")
        private WebElement address2;

        @FindBy(xpath = "//*[@id=\"state\"]")
        private WebElement state;

        @FindBy(xpath = "//*[@id=\"city\"]")
        private WebElement city;

        @FindBy(xpath = "//*[@id=\"zipcode\"]")
        private WebElement zipCode;

        @FindBy(xpath = "//*[@id=\"mobile_number\"]")
        private WebElement mobileNumber;

        @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/button")
        private WebElement createAccount;

        @FindBy(xpath = "//*[@id=\"country\"]")
        private WebElement unitedStates;

        @FindBy(xpath = "//*[@href=\"/delete_account\"]")
        private WebElement deleteAccount;

        @FindBy (xpath = "//*[@id=\"dismiss-button\"]/div")
        private WebElement closeAd;

        @FindBy (xpath = "//*[@id=\"form\"]/div/div/div/p[1]")
        private WebElement randomText;

        @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
        private WebElement confirmationCreatingAccount;

        @FindBy (xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a")
        private WebElement homePageButton;

        @FindBy (xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
        private WebElement logOutButton;

        public SignUpFullForm(WebDriver driver) {
            super(driver);
        }

//    public void fillEntireForm() throws InterruptedException, AWTException {
//            fillNewUserName();
//            fillNewUSerEmail();
//            clickSignUpButton();
//            selectGender("Mrs.");
//            fillPassword();
//            setDateOfBirth("28", "September", "1982");
//            elementsHelper.scrollDownMethod();
//            clickOnNewsletter();
//            clickOnSpecialOffers();
//            fillFirstName();
//            fillLastName();
//            elementsHelper.scrollDownMethod();
//            fillCompanyName();
//            fillInAddress1();
//            elementsHelper.scrollDownMethod();
//            fillInAddress2();
//            fillInState();
//            fillInCity();
//            fillInZipCode();
//            elementsHelper.scrollDownMethod();
//            fillInMobilePhone();
//            clickOnCreateAccountButton();
//            confirmationCreatingAccount.click();
//            homepageButton();
//        }

        public void fillEntireFormWithPropertiesData(Map<String, Object> fillFormData){
            selectGender((String) fillFormData.get("selectGender"));
            fillPassword((String) fillFormData.get("passwordValues"));
            setDateOfBirth((String) fillFormData.get("dateOfBirthValues"));
            elementsHelper.clickElement(newsletter);
            elementsHelper.clickElement(specialOffers);
            fillFirstName((String) fillFormData.get("firstNameValues"));
            fillLastName((String) fillFormData.get("lastNameValues"));
            fillCompanyName((String) fillFormData.get("companyNameValues"));
            fillAddress1Input((String) fillFormData.get("firstAddressValues"));
            fillAddress2Input((String) fillFormData.get("secondAddressValues"));
            fillStateInput((String) fillFormData.get("stateValues"));
            fillCityInput((String) fillFormData.get("cityValues"));
            fillZipCodeInput((String) fillFormData.get("zipCodeValues"));
            fillMobilePhoneInput((String) fillFormData.get("phoneNumberValues"));
            selectCountry((String) fillFormData.get("countryValues"));
            elementsHelper.clickElement(createAccount);
            elementsHelper.clickElement(homePageButton);
//            clickOnLogOutButton();
        }

        public void selectGender(String selectGender) {
            elementsHelper.clickElement(maleGenderElement);
        }

        public void fillPassword(String passwordValues){
            fillPassword.sendKeys(passwordValues);
        }

        public void setDateOfBirth(String dateOfBirthValues){
            elementsHelper.fillElement(dayOfBirth, dateOfBirthValues);
            Assert.assertEquals(dateOfBirth.size(), 3);
        }

        public void clickOnNewsletter(){
            elementsHelper.clickElement(newsletter);
        }

        public void clickOnSpecialOffers(){
            elementsHelper.clickElement(specialOffers);
        }

        public void fillFirstName(String firstNameValues){
            elementsHelper.fillElement(firstName, firstNameValues);
        }

        public void fillLastName(String lastNameValues){
            elementsHelper.fillElement(lastName, lastNameValues);
        }

        public void fillCompanyName(String companyNameValues){
            elementsHelper.fillElement(company, companyNameValues);
        }

        public void fillAddress1Input(String firstAddressValues){
            elementsHelper.fillElement(address1, firstAddressValues);
        }

        public void fillAddress2Input(String secondAddressValues){
            elementsHelper.fillElement(address2, secondAddressValues);
        }

        public void fillStateInput(String stateValues){
            elementsHelper.fillElement(state, stateValues);
        }

        public void fillCityInput(String cityValues){
            elementsHelper.fillElement(city, cityValues);
        }

        public void fillZipCodeInput(String zipCodeValues){
            elementsHelper.fillElement(zipCode, zipCodeValues);
        }

        public void fillMobilePhoneInput(String phoneNumberValues){
            elementsHelper.fillElement(mobileNumber, phoneNumberValues);
        }

        public void selectCountry(String countryValues){
            elementsHelper.clickElement(unitedStates);
            elementsHelper.fillElement(unitedStates, countryValues);
        }

        public void clickOnCreateAccountButton(){
            elementsHelper.clickElement(createAccount);
        }

        public void homepageButton(){
            elementsHelper.clickElement(homePageButton);
        }

        public void clickOnLogOutButton(){
            elementsHelper.clickElement(logOutButton);
        }


        @Override
       public void isPageLoaded() {
        }
    }
