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
    public void correctLogin() throws InterruptedIOException {
        driver.get(baseUrl + "/users/sign_in");
        LoginPage loginPage=new LoginPage();
        loginPage.login(driver,"focus5080+44@gmail.com", "focus5080");
        loginPage.logout(driver);

    }

    @Test
    public void incorrectEmail() {
        driver.get(baseUrl + "/users/sign_in");
        LoginPage loginPage=new LoginPage();
        loginPage.login(driver,"focus@gmail.com", "focus5080");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='new_user']/div[1]/span"));
        assertTrue(errorMessage.getText().contains("Invalid Email or password."));

    }

    @Test
    public void incorrectPassword() {
        driver.get(baseUrl + "/users/sign_in");
        LoginPage loginPage=new LoginPage();
        loginPage.login(driver,"focus5080+44@gmail.com", "123545");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='new_user']/div[1]/span"));
        assertTrue(errorMessage.getText().contains("Invalid Email or password."));

    }

    @Test
    public void emptyFields() {
        driver.get(baseUrl + "/users/sign_in");
        LoginPage loginPage=new LoginPage();
        loginPage.login(driver,"", "");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='new_user']/div[1]/span"));
        assertTrue(errorMessage.getText().contains("Can`t be blank"));

    }
}