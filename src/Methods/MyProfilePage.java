package Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by asus on 22.02.17.
 */
public class MyProfilePage {

    public void showProfile(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("My Profile")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean displayed = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/h2")).isDisplayed();
    }

    public void changeProfile(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("My Profile")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("user_first_name")).clear();
        driver.findElement(By.id("user_first_name")).sendKeys("Test");
        driver.findElement(By.id("user_last_name")).clear();
        driver.findElement(By.id("user_last_name")).sendKeys("Test");
        driver.findElement(By.id("user_company")).clear();
        driver.findElement(By.id("user_company")).sendKeys("Test");
        driver.findElement(By.cssSelector(".dd-pointer.dd-pointer-down")).click();
        driver.findElement(By.linkText("Algeria")).click();
        driver.findElement(By.name("commit")).click();
        boolean personal_info_notice = driver.findElement(By.id("personal_info_notice")).isDisplayed();
    }

    public void errorProfile(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("My Profile")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("user_first_name")).clear();
        driver.findElement(By.id("user_last_name")).clear();
        driver.findElement(By.id("user_company")).clear();
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.name("commit")).click();
        WebElement errorMessage = driver.findElement(By.className("message"));
        assertTrue(errorMessage.getText().contains("can't be blank"));
    }
}
