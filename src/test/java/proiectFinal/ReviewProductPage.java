package proiectFinal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;

public class ReviewProductPage extends BasePage {
    @FindBy(xpath = "//span[@class='pull-right' and text()='(5)']")
    private WebElement brand;

    @FindBy (xpath = "//a[@href=\"/product_details/28\"]")
    private WebElement viewProductDetails;

    @FindBy (xpath = "//input[@placeholder=\"Your Name\"]")
    private WebElement nameInput;

    @FindBy (xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy (xpath = "//textarea[@placeholder=\"Add Review Here!\"]")
    private WebElement reviewMessage;

    @FindBy (id = "button-review")
    private WebElement submitReview;

    public ReviewProductPage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);

    public void fillReviewForm(){
        actions.scrollToElement(brand).click(brand).perform();
        actions.scrollToElement(viewProductDetails).click(viewProductDetails).perform();
        elementsHelper.scrollDownMethod();
        elementsHelper.fillElement(nameInput, "Stanciu Ionut");
        elementsHelper.fillElement(emailInput, "itschool2025@gmail.com");
        elementsHelper.fillElement(reviewMessage, "This product has a very good quality and price as well");
        elementsHelper.clickElement(submitReview);
        logEvents(INFO_STEP, "Select an item and submit a review for it");
        elementsHelper.threadSleep(1000);
    }

    @Override
    public void isPageLoaded() {
    }
}
