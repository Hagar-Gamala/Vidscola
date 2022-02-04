package tests;

import pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    LoginPage loginObject;

    @Test
    public void UserOpenBankingManagerLogin() {
        loginObject = new LoginPage(driver);
        loginObject.openBankingManagerLogin();
    }
}
