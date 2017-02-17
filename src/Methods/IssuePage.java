package Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by asus on 14.02.17.
 */
public class IssuePage {


    public static void addIssue(WebDriver driver) throws InterruptedException {
        driver.findElement(By.linkText("My Projects")).click();
        driver.findElement(By.cssSelector(".project-name")).click();
        driver.findElement(By.linkText("Issues")).click();
        driver.findElement(By.linkText("Add new issue")).click();
        driver.findElement(By.name("commit")).click();
        Thread.sleep(5000);
    }

    public static void createIssue(WebDriver driver) throws InterruptedException {
        driver.findElement(By.linkText("My Projects")).click();
        driver.findElement(By.cssSelector(".project-name")).click();
        driver.findElement(By.linkText("Issues")).click();
        driver.findElement(By.linkText("Add new issue")).click();
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
    }

    public static void addColumns(WebDriver driver) {
        driver.findElement(By.linkText("My Projects")).click();
        driver.findElement(By.cssSelector(".project-name")).click();
        driver.findElement(By.linkText("Issues")).click();
        driver.findElement(By.cssSelector(".btn.btn-green.add-column")).click();
    }

    public static void  deleteIssue (WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.cssSelector(".card_message"))).doubleClick().build().perform();
        Thread.sleep(5000);
//        driver.findElement(By.xpath(".//*[@data-confirm='Are you sure you want to delete this issue?']")).click();
        driver.findElement(By.linkText("Delete")).click();
        driver.switchTo().alert().accept();
        // the rest of the scripts can be added here
    }

    public static void deleteColumn(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        WebElement from = driver.findElement(By.xpath(".//*/div/div[8]/div[1]/span"));
        WebElement to = driver.findElement(By.xpath(".//*/div[1]/div/div[2]/div/div/div/div[1]/div/div[1]/div[3]/div[3]/span"));
        new Actions(driver).dragAndDrop(from, to).perform();
        Thread.sleep(5000);
    }
}

