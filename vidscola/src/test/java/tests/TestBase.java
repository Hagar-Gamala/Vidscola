package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

public class TestBase {
    public static WebDriver driver;

    @BeforeSuite
    @Parameters(("browser"))
    public void startDriver(@Optional("chrome") String browserName){

        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\driver" + "\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "\\driver" + "\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.navigate().to("http://www.way2automation.com/protractor-angularjs-practice-website.html");
    }

    @AfterSuite
    public void stopDriver(){
        driver.quit();
    }

    //take screenshot when test case fail and it in the screenshot folder
    @AfterMethod
    public void screenshotOnFailure(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed!");
            System.out.println("Taking Screenshot ....");
            Helper.captureScreenshot(driver, result.getName());
        }
    }
}