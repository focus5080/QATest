package Tests;

import Methods.IssuePage;
import Methods.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by asus on 16.02.17.
 */
public class IssueTest  extends BaseTest {

    @Test
    public void createIssue() throws InterruptedException, InterruptedIOException {
        driver.get(baseUrl + "/users/sign_in");
        LoginPage loginPage = new LoginPage();
        LoginPage.login(driver, "focus5080+44@gmail.com", "focus5080");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage.createIssue(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        IssuePage.deleteIssue(driver);
        LoginPage.logout(driver);

    }

    @Test
    public void emptyFieldIssue() throws InterruptedException {
        driver.get(baseUrl + "/users/sign_in");
        LoginPage loginPage = new LoginPage();
        LoginPage.login(driver, "focus5080+44@gmail.com", "focus5080");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage.addIssue(driver);
        WebElement errorMessage = driver.findElement(By.className("message"));
        assertTrue(errorMessage.getText().contains("can't be blank"));
    }

    @Test
    public void changeStatusIssue() throws InterruptedException, InterruptedIOException {
        driver.get(baseUrl + "/users/sign_in");
        LoginPage loginPage = new LoginPage();
        LoginPage.login(driver, "focus5080+44@gmail.com", "focus5080");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage.createIssue(driver);
        WebElement from = driver.findElement(By.cssSelector(".card_message"));
        WebElement to = driver.findElement(By.xpath(".//*/div/div[7]"));
        new Actions(driver).dragAndDrop(from, to).perform();
        IssuePage.deleteIssue(driver);
        LoginPage.logout(driver);

    }

    @Test
    public void reportedByMe() throws InterruptedException, InterruptedIOException {
        driver.get(baseUrl + "/users/sign_in");
        LoginPage loginPage = new LoginPage();
        LoginPage.login(driver, "focus5080+44@gmail.com", "focus5080");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage.createIssue(driver);
        driver.findElement(By.xpath(".//*/div/div[1]/div[2]/span[5]")).click();
        driver.findElement(By.cssSelector("div.card_message > p")).click();
        IssuePage.deleteIssue(driver);
        LoginPage.logout(driver);

    }

    @Test
    public void addColumn() throws InterruptedException, InterruptedIOException {
        driver.get(baseUrl + "/users/sign_in");
        LoginPage loginPage = new LoginPage();
        LoginPage.login(driver, "focus5080+44@gmail.com", "focus5080");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage.addColumns(driver);
        Thread.sleep(5000);
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.xpath(".//*/div/div[8]/div[1]/span"))).doubleClick().build().perform();
        driver.findElement(By.xpath(".//*/div/div[8]/div[1]/div/input")).sendKeys("Test");
        IssuePage.deleteColumn(driver);
        LoginPage.logout(driver);
    }

    @Test
    public void changeColourColumn() throws InterruptedException, InterruptedIOException {
        driver.get(baseUrl + "/users/sign_in");
        LoginPage loginPage = new LoginPage();
        LoginPage.login(driver, "focus5080+44@gmail.com", "focus5080");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage.addColumns(driver);
        Thread.sleep(5000);
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.xpath(".//*/div/div[8]/div[1]/span"))).doubleClick().build().perform();
        driver.findElement(By.xpath(".//*/div/div[8]/div[1]/div/input")).sendKeys("Test1");
        driver.findElement(By.xpath(".//*/div/div[8]/div[2]")).click();
        driver.findElement(By.xpath(".//*[@id='color-picker']/ul/li[2]/span")).click();
        IssuePage.deleteColumn(driver);
        LoginPage.logout(driver);
    }

    @Test
    public void deleteColumn() throws InterruptedException, InterruptedIOException {
        driver.get(baseUrl + "/users/sign_in");
        LoginPage loginPage = new LoginPage();
        LoginPage.login(driver, "focus5080+44@gmail.com", "focus5080");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage.addColumns(driver);
        Thread.sleep(5000);
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.xpath(".//*/div/div[8]/div[1]/span"))).doubleClick().build().perform();
        driver.findElement(By.xpath(".//*/div/div[8]/div[1]/div/input")).sendKeys("Test2");
        IssuePage.deleteColumn(driver);
        LoginPage.logout(driver);

    }
}


