package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddCustomerPage;


public class AddCustomerTest extends TestBase{
    AddCustomerPage addCustomerObject;

    @DataProvider(name = "TestData")
    public static Object[][] userData() {
        return new Object[][]{
                {"Hagar", "Gamala", "123450"}
        };
    }
    @DataProvider(name = "TestsData")
    public static Object[][] usersData() {
        return (Object[][]) new Object[]{
                "Account created successfully with account Number :1016"
        };
    }

    @Test(priority = 1, dataProvider = "TestData")
    public void UserAddCustomer(String firstName, String lastName, String postCode) throws InterruptedException {
        addCustomerObject = new AddCustomerPage(driver);
        addCustomerObject.OpenAddCustomerForm(firstName, lastName, postCode);
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals("Customer added successfully with customer id :6", alertText);
        alert.accept();
        addCustomerObject.OpenSearchCustomer();
    }

    @Test(priority = 2, dataProvider = "TestsData")
    public void UserOpenAccount(String text) throws InterruptedException{
        addCustomerObject = new AddCustomerPage(driver);
        addCustomerObject.OpenAccount();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(text, alertText);
        alert.accept();
        addCustomerObject.OpenSearchCustomer();
    }

    @Test(priority = 3)
    public void UserDeleteCustomer() throws InterruptedException{
        addCustomerObject = new AddCustomerPage(driver);
        addCustomerObject.OpenSearchCustomer();
        addCustomerObject.OpenDeleteCustomerPage();
        Thread.sleep(1000);
    }
}
