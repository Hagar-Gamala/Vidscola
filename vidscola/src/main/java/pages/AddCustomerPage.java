package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage extends PageBase{
    public AddCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[1]/button[1]")
    WebElement CustomerButton;

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[1]/button[2]")
    WebElement AccountButton;

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[1]/button[3]")
    WebElement DeleteCustomer;

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div[1]/input")
    WebElement FirstnameField;

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div[2]/input")
    WebElement LastnameField;

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div[3]/input")
    WebElement PostcodeField;

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/button")
    WebElement AddCustomerButton;

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div/form/div/div/input")
    WebElement SearchField;

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div/div/table/tbody/tr/td[5]/button")
    WebElement DeleteButton;

    @FindBy(id = "userSelect")
    WebElement CustomerList;

    @FindBy(id = "currency")
    WebElement CurrencyList;

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/button")
    WebElement ProcessButton;


    public void OpenAddCustomerForm(String firstName, String lastName, String postCode){
        clickButton(CustomerButton);
        setTextElementText(FirstnameField, firstName);
        setTextElementText(LastnameField, lastName);
        setTextElementText(PostcodeField, postCode);
        clickButton(AddCustomerButton);
    }

    public void OpenAccount(){
        clickButton(AccountButton);
        Select customer = new Select(CustomerList);
        customer.selectByVisibleText("Hagar Gamala");
        customer.selectByIndex(6);
        Select currency = new Select(CurrencyList);
        currency.selectByVisibleText("Pound");
        currency.selectByIndex(2);
        clickButton(ProcessButton);
    }

    public void OpenSearchCustomer(){
        clickButton(DeleteCustomer);
        SearchField.clear();
        setTextElementText(SearchField, "Hagar");
    }

    public void OpenDeleteCustomerPage(){
        clickButton(DeleteButton);
    }

}
