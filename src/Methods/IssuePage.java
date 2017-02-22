package Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by asus on 14.02.17.
 */
public class IssuePage {


    public void addIssue(WebDriver driver) throws InterruptedException {
        driver.findElement(By.linkText("My Projects")).click();
        driver.findElement(By.linkText("testing EasyQa")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Issues")).click();
        driver.findElement(By.linkText("Add new issue")).click();
        driver.findElement(By.name("commit")).click();
        Thread.sleep(5000);
    }

    public void createIssue(WebDriver driver) throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("testing EasyQa")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("Issues")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("Add new issue")).click();
        Thread.sleep(500);
        driver.findElement(By.id("issue_summary")).click();
        driver.findElement(By.id("issue_summary")).sendKeys("Test Symphony");
        Thread.sleep(500);
        driver.findElement(By.linkText("Bug")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("Task")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("Medium")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("High")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(".//*[@id='priority-view']/div/a")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@id='priority-view']/ul/li[4]/a")).click();
        Thread.sleep(500);
        driver.findElement(By.name("commit")).click();
    }

    public void uploadFile(WebDriver driver) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("testing EasyQa")).click();
        driver.findElement(By.linkText("Issues")).click();
        driver.findElement(By.linkText("Add new issue")).click();
        driver.findElement(By.id("issue_summary")).click();
        driver.findElement(By.id("issue_summary")).sendKeys("Test Symphony");
        driver.findElement(By.linkText("Bug")).click();
        driver.findElement(By.linkText("Task")).click();
        driver.findElement(By.linkText("Medium")).click();
        driver.findElement(By.linkText("High")).click();
        driver.findElement(By.cssSelector("#priority-view > div.dd-select > a.dd-selected")).click();
        driver.findElement(By.xpath("//div[@id='priority-view']/ul/li[4]/a")).click();
    }

    public void attachFile(WebDriver driver) throws InterruptedException {
        WebElement attach = driver.findElement(By.xpath("//input[@type='file']"));
        attach.sendKeys("/media/asus/New/index.png");
        driver.findElement(By.name("commit")).click();
    }

    public void addColumns(WebDriver driver) throws InterruptedException {
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("testing EasyQa")).click();
        driver.findElement(By.linkText("Issues")).click();
        driver.findElement(By.cssSelector(".btn.btn-green.add-column")).click();
        Thread.sleep(5000);
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.xpath(".//*/div[8]/div[1]/span"))).doubleClick().build().perform();
        driver.findElement(By.xpath(".//*/div[8]/div[1]/div/input")).sendKeys("Test");
        Thread.sleep(2000);
    }

    public void addColumn(WebDriver driver) throws InterruptedException {
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("testing EasyQa")).click();
        driver.findElement(By.linkText("Issues")).click();
        driver.findElement(By.cssSelector(".btn.btn-green.add-column")).click();
    }

    public void  deleteIssue (WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.cssSelector(".card_message"))).doubleClick().build().perform();
        Thread.sleep(5000);
        // driver.findElement(By.xpath(".//*[@data-confirm='Are you sure you want to delete this issue?']")).click();
        driver.findElement(By.linkText("Delete")).click();
        driver.switchTo().alert().accept();
        // the rest of the scripts can be added here
        Thread.sleep(2000);
    }

    public void deleteColumn(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        WebElement from = driver.findElement(By.xpath(".//*/div/div[8]/div[1]/span"));
        WebElement to = driver.findElement(By.xpath(".//*/div[1]/div/div[2]/div/div/div/div[1]/div/div[1]/div[3]/div[3]/span"));
        new Actions(driver).dragAndDrop(from, to).perform();
        Thread.sleep(5000);
    }

    public void hideColumn(WebDriver driver) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("testing EasyQa")).click();
        driver.findElement(By.linkText("Issues")).click();
        driver.findElement(By.cssSelector(".btn.btn-green.open-columns-list")).click();
        Thread.sleep(2000);
    }

    public void searchIssue(WebDriver driver){
        driver.findElement(By.xpath("//input[@id='search']")). sendKeys("Test Symphony");
        driver.findElement(By.cssSelector(".search-btn")).click();
    }
}

