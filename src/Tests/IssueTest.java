package Tests;

import Methods.IssuePage;
import Methods.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by asus on 16.02.17.
 */
public class IssueTest  extends BaseTest {

    @Test
    public void acreateIssue() throws InterruptedException, InterruptedIOException {
        LoginPage  loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage issuePage = new IssuePage();
        issuePage.createIssue(driver);
        issuePage.deleteIssue(driver);
        loginPage.logout(driver);

    }



    @Test
    public void uploadFileIssue() throws InterruptedException, IOException {
        LoginPage  loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        IssuePage issuePage = new IssuePage();
        issuePage.uploadFile(driver);
        issuePage.deleteIssue(driver);
        loginPage.logout(driver);

    }

    @Test
    public void emptyFieldIssue() throws InterruptedException {
        LoginPage  loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage issuePage = new IssuePage();
        issuePage.addIssue(driver);
        WebElement errorMessage = driver.findElement(By.className("message"));
        assertTrue(errorMessage.getText().contains("can't be blank"));
    }

    @Test
    public void changeStatusToBe() throws InterruptedException, InterruptedIOException {
        LoginPage  loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage issuePage = new IssuePage();
        issuePage.createIssue(driver);
        WebElement from = driver.findElement(By.cssSelector(".card_message"));
        WebElement to = driver.findElement(By.xpath(".//*/div[2]/div[3]"));
        new Actions(driver).dragAndDrop(from, to).perform();
        Thread.sleep(5000);
        issuePage.deleteIssue(driver);
        loginPage.logout(driver);
    }

    @Test
    public void changeStatusReopen() throws InterruptedException, InterruptedIOException {
        LoginPage  loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage issuePage = new IssuePage();
        issuePage.createIssue(driver);
        WebElement from = driver.findElement(By.cssSelector(".card_message"));
        WebElement to = driver.findElement(By.xpath(".//*/div[3]/div[3]"));
        new Actions(driver).dragAndDrop(from, to).perform();
        Thread.sleep(5000);
        issuePage.deleteIssue(driver);
        loginPage.logout(driver);
    }

    @Test
    public void changeStatusInProgress() throws InterruptedException, InterruptedIOException {
        LoginPage  loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage issuePage = new IssuePage();
        issuePage.createIssue(driver);
        WebElement from = driver.findElement(By.cssSelector(".card_message"));
        WebElement to = driver.findElement(By.xpath(".//*/div[4]/div[3]"));
        new Actions(driver).dragAndDrop(from, to).perform();
        Thread.sleep(5000);
        issuePage.deleteIssue(driver);
        loginPage.logout(driver);
    }

    @Test
    public void changeCodeReview() throws InterruptedException, InterruptedIOException {
        LoginPage  loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage issuePage = new IssuePage();
        issuePage.createIssue(driver);
        WebElement from = driver.findElement(By.cssSelector(".card_message"));
        WebElement to = driver.findElement(By.xpath(".//*/div[5]/div[3]"));
        new Actions(driver).dragAndDrop(from, to).perform();
        Thread.sleep(5000);
        issuePage.deleteIssue(driver);
        loginPage.logout(driver);
    }

    @Test
    public void changeStatusQAReview() throws InterruptedException, InterruptedIOException {
        LoginPage  loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage issuePage = new IssuePage();
        issuePage.createIssue(driver);
        WebElement from = driver.findElement(By.cssSelector(".card_message"));
        WebElement to = driver.findElement(By.xpath(".//*/div[6]/div[3]"));
        new Actions(driver).dragAndDrop(from, to).perform();
        Thread.sleep(5000);
        issuePage.deleteIssue(driver);
        loginPage.logout(driver);
    }


    @Test
    public void changeStatusClosed() throws InterruptedException, InterruptedIOException {
        LoginPage  loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage issuePage = new IssuePage();
        issuePage.createIssue(driver);
        WebElement from = driver.findElement(By.cssSelector(".card_message"));
        WebElement to = driver.findElement(By.xpath(".//*/div/div[7]"));
        new Actions(driver).dragAndDrop(from, to).perform();
        Thread.sleep(5000);
        issuePage.deleteIssue(driver);
        loginPage.logout(driver);
    }

    @Test
    public void areportedByMe() throws InterruptedException, InterruptedIOException {
        LoginPage  loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage issuePage = new IssuePage();
        issuePage.createIssue(driver);
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*/div[2]/span[5]")).click();
        driver.findElement(By.cssSelector("div.card_message > p")).click();
        issuePage.deleteIssue(driver);
        loginPage.logout(driver);

    }

    @Test
    public void addColumn() throws InterruptedException, InterruptedIOException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage issuePage = new IssuePage();
        issuePage.addColumn(driver);
        issuePage.deleteColumn(driver);
        loginPage.logout(driver);
    }

    @Test
    public void changeColourColumn() throws InterruptedException, InterruptedIOException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage issuePage = new IssuePage();
        issuePage.addColumns(driver);
        driver.findElement(By.xpath(".//*/div/div[8]/div[2]")).click();
        driver.findElement(By.xpath(".//*[@id='color-picker']/ul/li[2]/span")).click();
        issuePage.deleteColumn(driver);
        loginPage.logout(driver);
    }

    @Test
    public void deleteColumn() throws InterruptedException, InterruptedIOException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        IssuePage issuePage = new IssuePage();
        issuePage.addColumns(driver);
        issuePage.deleteColumn(driver);
        loginPage.logout(driver);
    }

    @Test
    public void showColumnList() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        IssuePage issuePage = new IssuePage();
        issuePage.addColumn(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[@class='drop-arrow']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement field = driver.findElement(By.tagName("label"));
        field.getText().contains("Submitted");
        Thread.sleep(2000);
    }

    @Test
    public void hideColumn() throws InterruptedException, InterruptedIOException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        IssuePage issuePage = new IssuePage();
        issuePage.hideColumn(driver);
        driver.findElement(By.xpath("//label[text()='Submitted']")).click();
        Thread.sleep(2000);
        issuePage.hideColumn(driver);
        driver.findElement(By.xpath("//label[text()='Submitted']")).click();
        loginPage.logout(driver);
    }

    @Test
    public void hideColumn1() throws InterruptedException, InterruptedIOException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        IssuePage issuePage = new IssuePage();
        issuePage.hideColumn(driver);
        driver.findElement(By.xpath("//label[text()='To be discussed']")).click();
        Thread.sleep(2000);
        issuePage.hideColumn(driver);
        driver.findElement(By.xpath("//label[text()='To be discussed']")).click();
        loginPage.logout(driver);
    }

    @Test
    public void hideColumn2() throws InterruptedException, InterruptedIOException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        IssuePage issuePage = new IssuePage();
        issuePage.hideColumn(driver);
        driver.findElement(By.xpath("//label[text()='Reopened']")).click();
        Thread.sleep(2000);
        issuePage.hideColumn(driver);
        driver.findElement(By.xpath("//label[text()='Reopened']")).click();
        loginPage.logout(driver);
    }

    @Test
    public void hideColumn3() throws InterruptedException, InterruptedIOException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        IssuePage issuePage = new IssuePage();
        issuePage.hideColumn(driver);
        driver.findElement(By.xpath("//label[text()='In Progress']")).click();
        Thread.sleep(2000);
        issuePage.hideColumn(driver);
        driver.findElement(By.xpath("//label[text()='In Progress']")).click();
        loginPage.logout(driver);
    }

    @Test
    public void hideColumn4() throws InterruptedException, InterruptedIOException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        IssuePage issuePage = new IssuePage();
        issuePage.hideColumn(driver);
        driver.findElement(By.xpath("//label[text()='Code Review']")).click();
        Thread.sleep(2000);
        issuePage.hideColumn(driver);
        driver.findElement(By.xpath("//label[text()='Code Review']")).click();
        loginPage.logout(driver);
    }

    @Test
    public void hideColumn5() throws InterruptedException, InterruptedIOException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        IssuePage issuePage = new IssuePage();
        issuePage.hideColumn(driver);
        driver.findElement(By.xpath("//label[text()='QA Review']")).click();
        Thread.sleep(2000);
        issuePage.hideColumn(driver);
        driver.findElement(By.xpath("//label[text()='QA Review']")).click();
        loginPage.logout(driver);
    }

    @Test
    public void hideColumn6() throws InterruptedException, InterruptedIOException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        IssuePage issuePage = new IssuePage();
        issuePage.hideColumn(driver);
        driver.findElement(By.xpath("//label[text()='Closed']")).click();
        Thread.sleep(2000);
        issuePage.hideColumn(driver);
        driver.findElement(By.xpath("//label[text()='Closed']")).click();
        loginPage.logout(driver);
    }

    @Test
    public void searchIssue() throws InterruptedException, InterruptedIOException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver, "vasiliy.fedortsi@thinkmobiles.com", "111111");
        IssuePage issuePage = new IssuePage();
        issuePage.createIssue(driver);
        issuePage.searchIssue(driver);
        issuePage.deleteIssue(driver);
        loginPage.logout(driver);
    }
}


