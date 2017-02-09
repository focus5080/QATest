package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by asus on 09.02.17.
 */
public class BaseTest {

    public WebDriver driver;
    public String baseUrl = "http://qa_dashboard.test.thinkmobiles.com:8085";

    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
    }

}
