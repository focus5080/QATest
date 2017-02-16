package Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by asus on 14.02.17.
 */
public class IssuePage {


    public static void addIssue(WebDriver driver){
        driver.findElement(By.linkText("My Projects")).click();
        driver.findElement(By.cssSelector(".project-name")).click();
        driver.findElement(By.linkText("Issues")).click();
        driver.findElement(By.linkText("Add new issue")).click();

    }

    public static void addColumn(WebDriver driver) {
        driver.findElement(By.linkText("My Projects")).click();
        driver.findElement(By.cssSelector(".project-name")).click();
        driver.findElement(By.linkText("Issues")).click();

    }

}

