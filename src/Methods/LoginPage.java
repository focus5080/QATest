package Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by asus on 09.02.17.
 */
public class LoginPage {


        public static void login(WebDriver driver, String email, String pass){
        driver.findElement(By.id("user_email")).click();
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys(email);
        driver.findElement(By.id("user_password")).click();
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys(pass);
        driver.findElement(By.name("commit")).click();
    }

    public static void logout(WebDriver driver) throws InterruptedIOException {
        // driver.manage().timeouts().implicityWait(5, TimeUnit.SECONDS); */
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("SvgjsSvg1000")).click();
    }
}
