package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends TestBase{
    HomePage homeObject;

    @Test
    public void UserOpenBankingLink(){
        homeObject = new HomePage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        homeObject.openBankingPage();
    }
}
