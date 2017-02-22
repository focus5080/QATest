package Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by asus on 09.02.17.
 */
public class LoginPage {


    public void login(WebDriver driver, String email, String pass){

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.findElement(By.id("user_email")).click();
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys(email);
        driver.findElement(By.id("user_password")).click();
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys(pass);
        driver.findElement(By.name("commit")).click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    public void logout(WebDriver driver) throws InterruptedIOException, InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".log_out")).click();
    }

    public void assertError(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement errorMessage = driver.findElement(By.className("message"));
        assertTrue(errorMessage.getText().contains("Invalid Email or password."));
    }
}
