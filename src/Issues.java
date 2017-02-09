import Methods.LoginPage;
import Tests.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by asus on 09.02.17.
 */
public class Issues extends BaseTest {

    @Test
    public void openPersonalInfo() {
        driver.get(baseUrl + "/users/sign_in");
        LoginPage loginPage=new LoginPage();
        loginPage.login(driver,"focus5080+44@gmail.com", "focus5080");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("My Projects")).click();
        driver.findElement(By.cssSelector("img.project-logo")).click();
        driver.findElement(By.linkText("Issues")).click();
        driver.findElement(By.linkText("Add new issue")).click();
        driver.findElement(By.id("issue_summary")).clear();
        driver.findElement(By.id("issue_summary")).sendKeys("Test Symphony");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='new_issue']/div[2]/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(".//*[@id='mCSB_4_container']/div/div[1]/div[3]/div/div[2]/div[1]/p"))).doubleClick().perform();
        driver.findElement(By.linkText("Delete")).click();
        Alert javascriptAlert = driver.switchTo().alert();
        javascriptAlert.accept();
    }

}

