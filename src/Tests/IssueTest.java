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
        public void bcreateIssue() throws InterruptedException, InterruptedIOException {
            driver.get(baseUrl + "/users/sign_in");
            LoginPage loginPage=new LoginPage();
            LoginPage.login(driver,"focus5080+44@gmail.com", "focus5080");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            IssuePage.addIssue(driver);
            driver.findElement(By.id("issue_summary")).click();
            driver.findElement(By.id("issue_summary")).sendKeys("Test Symphony");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.findElement(By.xpath(".//*[@id='new_issue']/div[2]/input")).click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,250)", "");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            Actions action = new Actions(driver);
            action.doubleClick(driver.findElement(By.cssSelector(".card_message"))).doubleClick().build().perform();
            Thread.sleep(5000);
//        driver.findElement(By.xpath(".//*[@data-confirm='Are you sure you want to delete this issue?']")).click();
            driver.findElement(By.linkText("Delete")).click();
            driver.switchTo().alert().accept();
            // the rest of the scripts can be added here
            LoginPage.logout(driver);

        }

        @Test
        public void aemptyFieldIssue() throws InterruptedException, InterruptedIOException {
            driver.get(baseUrl + "/users/sign_in");
            LoginPage loginPage=new LoginPage();
            LoginPage.login(driver,"focus5080+44@gmail.com", "focus5080");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            IssuePage.addIssue(driver);
            driver.findElement(By.name("commit")).click();
            Thread.sleep(5000);
            WebElement errorMessage = driver.findElement(By.className("message"));
            assertTrue(errorMessage.getText().contains("can't be blank"));
            LoginPage.logout(driver);
        }

        @Test
        public void changeStatusIssue() throws InterruptedException, InterruptedIOException {
            driver.get(baseUrl + "/users/sign_in");
            LoginPage loginPage=new LoginPage();
            LoginPage.login(driver,"focus5080+44@gmail.com", "focus5080");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            IssuePage.addIssue(driver);
            driver.findElement(By.id("issue_summary")).click();
            driver.findElement(By.id("issue_summary")).sendKeys("Test Symphony");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.findElement(By.xpath(".//*[@id='new_issue']/div[2]/input")).click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement from = driver.findElement(By.cssSelector(".card_message"));
            WebElement to = driver.findElement(By.xpath(".//*/div/div[7]"));
            new Actions(driver).dragAndDrop(from, to).perform();
            Thread.sleep(5000);
            Actions action = new Actions(driver);
            action.doubleClick(driver.findElement(By.cssSelector(".card_message"))).doubleClick().build().perform();
            Thread.sleep(5000);
            //        driver.findElement(By.xpath(".//*[@data-confirm='Are you sure you want to delete this issue?']")).click();
            driver.findElement(By.linkText("Delete")).click();
            driver.switchTo().alert().accept();
            // the rest of the scripts can be added here
            LoginPage.logout(driver);

        }

        @Test
        public void reportedByMe () throws InterruptedException, InterruptedIOException {
            driver.get(baseUrl + "/users/sign_in");
            LoginPage loginPage=new LoginPage();
            LoginPage.login(driver,"focus5080+44@gmail.com", "focus5080");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            IssuePage.addIssue(driver);
            driver.findElement(By.id("issue_summary")).click();
            driver.findElement(By.id("issue_summary")).sendKeys("Test Symphony");
            driver.findElement(By.linkText("Not assigned")).click();
            driver.findElement(By.linkText("Ласло Vasces")).click();
            driver.findElement(By.linkText("Bug")).click();
            driver.findElement(By.linkText("Task")).click();
            driver.findElement(By.linkText("Medium")).click();
            driver.findElement(By.linkText("High")).click();
            driver.findElement(By.cssSelector("#priority-view > div.dd-select > a.dd-selected")).click();
            driver.findElement(By.xpath("//div[@id='priority-view']/ul/li[4]/a")).click();
            driver.findElement(By.name("commit")).click();
            driver.findElement(By.xpath(".//*/div/div[1]/div[2]/span[5]")).click();
            driver.findElement(By.cssSelector("div.card_message > p")).click();
            Actions action = new Actions(driver);
            action.doubleClick(driver.findElement(By.cssSelector(".card_message"))).doubleClick().build().perform();
            Thread.sleep(5000);
            //        driver.findElement(By.xpath(".//*[@data-confirm='Are you sure you want to delete this issue?']")).click();
            driver.findElement(By.linkText("Delete")).click();
            driver.switchTo().alert().accept();
            // the rest of the scripts can be added here
            LoginPage.logout(driver);

        }

        @Test
        public void addColumn () throws InterruptedException, InterruptedIOException {
            driver.get(baseUrl + "/users/sign_in");
            LoginPage loginPage=new LoginPage();
            LoginPage.login(driver,"focus5080+44@gmail.com", "focus5080");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            IssuePage.addColumn(driver);
            driver.findElement(By.cssSelector(".btn.btn-green.add-column")).click();
            Thread.sleep(5000);
            Actions action = new Actions(driver);
            action.doubleClick(driver.findElement(By.xpath(".//*/div/div[8]/div[1]/span"))).doubleClick().build().perform();
            Thread.sleep(5000);
            driver.findElement(By.xpath(".//*/div/div[8]/div[1]/span")).sendKeys("Test");


        }

    }


