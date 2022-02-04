package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[1]/div[2]/button")
    WebElement BankingManagerButton;

    public void openBankingManagerLogin(){
        clickButton(BankingManagerButton);
    }
}
