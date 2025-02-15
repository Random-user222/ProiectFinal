package proiectFinalTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import proiectFinal.HomePage;
import propertyUtility.PropertyUtility;
import static extentUtility.ExtentManager.*;

public class TestPage {

    public WebDriver driver;
    public PropertyUtility propertyUtility;
    public String testName;
    public HomePage homePage;
    @BeforeSuite
    public void initiateReport(){
        initializeReport();
    }

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);

        driver.get("https://www.automationexercise.com/");
        //Facem fereastra la dimensiunea maxima:
        driver.manage().window().maximize();

        testName = this.getClass().getSimpleName();
        createTest(testName);

        //Facem fereastra la dimensiunea dorita: 1980 cu 1080
        // driver.manage().window().setSize(new Dimension(1980, 1080));

    }

    @AfterMethod
    public void quitBrowser(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            String errorMessage = result.getThrowable().getMessage();
            logFailWithScreenshot(errorMessage, driver);
        }
//        if (driver != null){
//            driver.quit();
//        }
        finishTest(testName);
    }

    @AfterSuite
    public void finalizeReport(){
        generateReport();
    }
}
