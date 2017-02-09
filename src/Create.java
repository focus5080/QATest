import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by asus on 08.02.17.
 */
public class Create {

    @Test
    public void main() {
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://qa_dashboard.test.thinkmobiles.com:8085";
        driver.get(baseUrl + "/users/sign_in");
        driver.findElement(By.id("user_email")).click();
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys("focus5080+44@gmail.com");
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("focus5080");
        driver.findElement(By.name("commit")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("My Projects")).click();
        driver.findElement(By.cssSelector("img.project-logo")).click();
        driver.findElement(By.linkText("Issues")).click();
        driver.findElement(By.linkText("Add new issue")).click();
        driver.findElement(By.id("issue_summary")).click();
        driver.findElement(By.id("issue_summary")).clear();
        driver.findElement(By.id("issue_summary")).sendKeys("Test Test");
        driver.findElement(By.id("issue_description")).click();
        driver.findElement(By.linkText("Bug")).click();
        driver.findElement(By.xpath("//div[@id='type-view']/ul/li[4]/a/label")).click();
        driver.findElement(By.cssSelector("#severity-view > div.dd-select > a.dd-selected > label.dd-selected-text")).click();
        driver.findElement(By.linkText("High")).click();
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.xpath("//div[@id='mCSB_8_container']/div/div/div[3]/div[18]/div[2]/div[2]")).click();
        driver.findElement(By.xpath("//div[@id='mCSB_8_container']/div/div/div[3]/div[18]/div[2]/div[2]")).click();
        driver.findElement(By.cssSelector("span.close > #SvgjsSvg1000 > #SvgjsPath1007")).click();
        driver.findElement(By.xpath("//div[@id='mCSB_8_container']/div/div/div[3]/div[5]/div[2]/div[2]")).click();
        driver.findElement(By.xpath("//div[@id='mCSB_8_container']/div/div/div[3]/div[5]/div[2]/div[2]")).click();
        driver.findElement(By.linkText("Delete")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("SvgjsSvg1000")).click();

    }
}