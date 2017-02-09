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
public class Base {
    public ChromeDriver driver;
    public String baseUrl = "http://qa_dashboard.test.thinkmobiles.com:8085";

    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
    }

    public void login(String email, String pass){
        driver.findElement(By.id("user_email")).click();
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys(email);
        driver.findElement(By.id("user_password")).click();
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys(pass);
        driver.findElement(By.name("commit")).click();
    }

    public void logout() throws InterruptedIOException {
        // driver.manage().timeouts().implicityWait(5, TimeUnit.SECONDS); */
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("SvgjsSvg1000")).click();
    }
}
