package proiectFinal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;

import java.awt.*;

import java.util.List;
import java.util.Map;

public class SignUpFullForm extends BasePage{
        @FindBy(id = "id_gender1")
        private WebElement maleGenderElement;

        @FindBy(xpath = "//input[@data-qa='password']")
        private WebElement fillPassword;

        @FindBy(xpath = "//select[@data-qa='days']")
        private WebElement dayOfBirth;

        @FindBy(xpath = "//input[@type='checkbox']")
        private WebElement newsletter;

        @FindAll({
                @FindBy(id = "days"),
                @FindBy(id = "months"),
                @FindBy(id = "years")
        })
        private List<WebElement> dateOfBirth;

        @FindBy(xpath = "//input[@id='optin']")
        private WebElement specialOffers;

        @FindBy(xpath = "//input[@data-qa='first_name']")
        private WebElement firstName;

        @FindBy(xpath = "//input[@data-qa='last_name']")
        private WebElement lastName;

        @FindBy(xpath = "//input[@data-qa='company']")
        private WebElement company;

        @FindBy(xpath = "//input[@data-qa='address']")
        private WebElement address1;

        @FindBy(xpath = "//input[@data-qa='address2']")
        private WebElement address2;

        @FindBy(xpath = "//select[@data-qa='country']")
        private WebElement unitedStates;

        @FindBy(xpath = "//input[@data-qa='state']")
        private WebElement state;

        @FindBy(xpath = "//input[@data-qa='city']")
        private WebElement city;

        @FindBy(xpath = "//input[@data-qa='zipcode']")
        private WebElement zipCode;

        @FindBy(xpath = "//input[@data-qa='mobile_number']")
        private WebElement mobileNumber;

        @FindBy(xpath = "//button[@data-qa='create-account']")
        private WebElement createAccount;

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
            logEvents(INFO_STEP, "Using DataProperties to fill the entire SignUp Form");
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

        @Override
       public void isPageLoaded() {
        }
    }
