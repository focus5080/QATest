package Tests;

import Methods.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by asus on 09.02.17.
 */
public class MyProfileTest extends BaseTest {

    @Test
    public void openPersonalInfo() {
        driver.get(baseUrl + "/users/sign_in");
        LoginPage loginPage=new LoginPage();
        loginPage.login(driver,"focus5080+44@gmail.com", "focus5080");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("My Profile")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='content']/div/div[1]/h2")).isDisplayed();

    }

    @Test
    public void changePersonalInfo() {
        driver.get(baseUrl + "/users/sign_in");
        LoginPage loginPage=new LoginPage();
        loginPage.login(driver,"focus5080+44@gmail.com", "focus5080");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("My Profile")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("user_first_name")).clear();
        driver.findElement(By.id("user_first_name")).sendKeys("Test");
        driver.findElement(By.id("user_last_name")).clear();
        driver.findElement(By.id("user_last_name")).sendKeys("Test");
        driver.findElement(By.id("user_company")).clear();
        driver.findElement(By.id("user_company")).sendKeys("Test");
        driver.findElement(By.cssSelector("span.dd-pointer.dd-pointer-down")).click();
        driver.findElement(By.linkText("Algeria")).click();
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.id("personal_info_notice")).isDisplayed();
    }

    @Test
    public void emptyPersonalInfo() {
        driver.get(baseUrl + "/users/sign_in");
        LoginPage loginPage=new LoginPage();
        loginPage.login(driver,"focus5080+44@gmail.com", "focus5080");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("My Profile")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("user_first_name")).clear();
        driver.findElement(By.id("user_last_name")).clear();
        driver.findElement(By.id("user_company")).clear();
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.name("commit")).click();
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='edit_user_24']/div[4]/div[2]/label"));
        assertTrue(errorMessage.getText().contains("can't be blank"));
    }
}
