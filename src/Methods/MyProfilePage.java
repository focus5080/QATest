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

    public void showProfile(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("My Profile")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='content']/div/div[1]/h2")).isDisplayed();
    }

    public void changeProfile(WebDriver driver) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("My Profile")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("user_first_name")).clear();
        driver.findElement(By.id("user_first_name")).sendKeys("Test");
        driver.findElement(By.id("user_last_name")).clear();
        driver.findElement(By.id("user_last_name")).sendKeys("Test");
        driver.findElement(By.id("user_company")).clear();
        driver.findElement(By.id("user_company")).sendKeys("Test");
        driver.findElement(By.id("user_company")).submit();
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='success']"));
        errorMessage.isDisplayed();
        assertTrue(errorMessage.getText().contains("update success"));
    }

    public void errorProfile(WebDriver driver) {
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

    public void uploadFile(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath(".//*[@id='upload_avatar']/div[1]")).click();
        WebElement attach = driver.findElement(By.xpath("//input[@type='file']"));
        attach.sendKeys("/media/asus/New/index.png");
        Thread.sleep(2000);
    }

    public void changePassword(WebDriver driver){
        driver.findElement(By.xpath(".//*/div/ul/li[2]/a/span")).click();
        driver.findElement(By.id("current_password")).sendKeys("11111");
        driver.findElement(By.id("user_password")).sendKeys("111111");
        driver.findElement(By.id("user_password_confirmation")).sendKeys("111111");
        driver.findElement(By.name("commit"));
    }

    public void errorMessage(WebDriver driver){
        driver.findElement(By.xpath(".//*/div/ul/li[2]/a/span")).click();
        driver.findElement(By.id("current_password")).sendKeys("11111");
        driver.findElement(By.id("user_password")).sendKeys("");
        driver.findElement(By.id("user_password_confirmation")).sendKeys("");
        driver.findElement(By.name("commit"));
        WebElement errorMessage = driver.findElement(By.className("message"));
        assertTrue(errorMessage.getText().contains("can't be blank"));
    }
}
