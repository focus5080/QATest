package Tests;

import Methods.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by asus on 08.02.17.
 */
public class LoginTest extends BaseTest {


    @Test
    public void correctLogin() throws InterruptedIOException, InterruptedException {
        LoginPage  loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        loginPage.logout(driver);

    }

    @Test
    public void incorrectEmail() throws InterruptedIOException {
        LoginPage  loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobilesffff.com", "111111");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.assertError(driver);
    }

    @Test
    public void incorrectPassword() throws InterruptedIOException {
        LoginPage  loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "1112222111");
        loginPage.assertError(driver);
    }

    @Test
    public void emptyFields() throws InterruptedIOException {
        LoginPage  loginPage = new LoginPage();
        loginPage.login(driver,"", "");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement errorMessage = driver.findElement(By.className("message"));
        assertTrue(errorMessage.getText().contains("can't be blank"));

    }
}