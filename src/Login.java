import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

/**
 * Created by asus on 08.02.17.
 */
public class Login extends Base {


    @Test
    public void positiveLogin() throws InterruptedIOException {
        driver.get(baseUrl + "/users/sign_in");
        login("focus5080+44@gmail.com", "focus5080");
        logout();

    }

    @Test
    public void incorrectEmail() {
        driver.get(baseUrl + "/users/sign_in");
        login("focus@gmail.com", "focus5080");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='new_user']/div[1]/span"));
        assertTrue(errorMessage.getText().contains("Invalid Email or password."));

    }

    @Test
    public void incorrectPassword() {
        driver.get(baseUrl + "/users/sign_in");
        login("focus5080+44@gmail.com", "123545");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='new_user']/div[1]/span"));
        assertTrue(errorMessage.getText().contains("Invalid Email or password."));

    }

    @Test
    public void emptyFields() {
        driver.get(baseUrl + "/users/sign_in");
        login("", "");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='new_user']/div[1]/span"));
        assertTrue(errorMessage.getText().contains("Can`t be blank"));

    }
}