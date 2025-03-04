package proiectFinal;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;

import java.time.Duration;
import java.util.List;

public class ShoppingPage extends BasePage{
    @FindBy (xpath = "//*[@id=\"accordian\"]/div[2]/div[1]/h4/a/span")
    private WebElement category;

    @FindBy (xpath = "//a[text()='Tshirts ']")
    private WebElement product;

    @FindBy (xpath = "//a[@data-product-id=\"29\"]")
    private WebElement tShirt;

    @FindBy (xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
    private WebElement continueToShoppingButton;

    @FindBy (xpath = "//span[@class='pull-right' and text()='(5)']")
    private WebElement brand;

    @FindBy (xpath = "/html/body/section/div/div[2]/div[2]/div/div[4]/div/div[2]/ul/li/a")
    private WebElement viewProductDetails;

    @FindBy (xpath = "//input[@id='quantity']")
    private WebElement quantity;

    @FindBy (xpath = "//button[@type=\"button\"]")
    private WebElement addToCart;

    public ShoppingPage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);

    public void actionsOnShoppingPage(){
        selectCategory();
        selectProduct();
        addATShirt();
        clickOnContinueShoppingButton();
        selectBrand();
        selectBrandProduct();
        enterTheQuantity();
        addToCart();
        clickOnContinueShoppingButton();
        logEvents(INFO_STEP, "Select few items based on filters and select the quantity we want");
    }

    public void selectCategory(){
        elementsHelper.clickElement(category);
    }

    public void selectProduct(){
        elementsHelper.waitForElement(product);
        elementsHelper.clickElement(product);
    }

    public void addATShirt(){
        actions.scrollToElement(tShirt).click(tShirt).perform();
    }

    public void clickOnContinueShoppingButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"]")));
        elementsHelper.clickElement(continueToShoppingButton);
    }

    public void selectBrand(){
        elementsHelper.clickElement(brand);
    }

    public void selectBrandProduct(){
        elementsHelper.clickElement(viewProductDetails);
    }

    public void enterTheQuantity(){
        elementsHelper.keyboardEnters(quantity, Keys.BACK_SPACE);
        elementsHelper.fillElement(quantity, "2");
    }

    public void addToCart(){
        elementsHelper.clickElement(addToCart);
    }

    @Override
    public void isPageLoaded() {
    }
}
